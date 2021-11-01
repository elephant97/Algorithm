#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>


// places_rows는 2차원 배열 places의 행 길이, places_cols는 2차원 배열 places의 열 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.

int check_sit(char **places, int places_rows, int places_cols);

int* solution(const char*** places, size_t places_rows, size_t places_cols) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int)*places_cols);    
    char **copy_places = (char**)malloc(sizeof(places[0]));
    int i = 0;
    
    memset(answer, 0, sizeof(int)*places_cols);
    
    while(i < 5)
    {
        memcpy(copy_places,places[i],sizeof(copy_places));
        answer[i] = check_sit(copy_places, places_rows, places_cols);
        
        i++;
    }  
    
    
    return answer;
}

int check_sit(char **places, int places_rows, int places_cols)
{
    int Manhattan_arr[2] = {0,};
    int i = 0, j = 0;
    int save = 0;
    bool partition_flag = false;
    int NO = 0;
    int YES = 1;
    char *str = NULL;
    
    for(i = 0; i < places_rows; i++)
    {
        memset(Manhattan_arr, (-1), sizeof(int)*2); //초기화
        partition_flag = false;
        printf("%s\n",places[i]);
        // strcpy(str,places[i]);
        if(strchr(places[i],'P') == NULL) //대기실에 사람이 한 명도 없는지 체크
        {
            printf("##%s\n",places[i]);
            // if((places_rows - 1) == i)
            // {
            //     // save = 1;            
            //     break;
            // }
            // else
            // {
            //     continue;
            // }
        }
        
        for(j = 0; j < places_cols; j++)
        {
            if(&places[i][j] == 'P')
            {
                if(Manhattan_arr[1] == (j-1))
                {
                    save = NO;
                    break;
                }
                else if(j == 0)
                {
                    Manhattan_arr[0] = i;
                    Manhattan_arr[1] = j;
                }
                else
                {
                    if( (i > 0) && ((&places[i-1][j] == 'P') || 
                                   ((j > 0) && (&places[i-1][j-1] == 'P') && partition_flag == false && (&places[i-1][j] != 'X')) ) )
                    {  
                        save = NO;
                        break;
                    }
                    else
                    {
                        save = ( ((j - Manhattan_arr[1]) <= 2) || partition_flag == false) ?  YES : NO;
                        if(save == NO)
                        {
                            break;
                        }
                    }
                }
                partition_flag = false;
            }
            else if(&places[i][j] == 'X')
            {
                partition_flag = true;
            }

        }
        
        if(save == NO)
        {
            break;
        }
        
    }
    
    return save;
}
