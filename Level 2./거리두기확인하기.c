#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

/*수정필요*/
// places_rows는 2차원 배열 places의 행 길이, places_cols는 2차원 배열 places의 열 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.

int check_sit(char **places, int places_rows, int places_cols);

int* solution(const char*** places, size_t places_rows, size_t places_cols) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int)*places_cols);    
    // char **copy_places = (char**)malloc(sizeof(places[0]));
    int i = 0;
    
    memset(answer, 0, sizeof(int)*places_cols);
    
    while(i < 5)
    {
        // memcpy(copy_places,places[i],sizeof(copy_places));
        printf("-----------------------\n");
        answer[i] = check_sit(places[i], places_rows, places_cols);
        
        i++;
    }  
    
    
    return answer;
}

int check_sit(char **places, int places_rows, int places_cols)
{
    int Manhattan_arr[2] = {0,};
    int i = 0, j = 0;
    int save = 1;
    bool partition_flag = false;
    int NO = 0;
    int YES = 1;
    int nobody_check = 0;
    char temp[5] = {0,};
    
    for(i = 0; i < places_rows; i++)
    {
        memset(Manhattan_arr, -10, sizeof(int)*2); //초기화
        partition_flag = false;
        printf("%s[%d]\n",places[i],places_rows);
        sprintf(temp, "%s",places[i]);
        if(strchr(temp,'P') == NULL) //대기실에 사람이 한 명도 없는지 체크
        {
            // printf("##%s\n",places[i]);
            if(nobody_check == i)
            {
                save = 1; 
                printf("%d\n",__LINE__);
                break;
            }
            else
            {
                nobody_check++;
                continue;
            }
        }
        
        for(j = 0; j < places_cols; j++)
        {
            printf("###############%c[j=%d]\n",places[i][j],j);
            if(places[i][j] == 'P')
            {
                if(Manhattan_arr[1] == (j-1))
                {
                    save = NO;
                    printf("%d[%d]\n",__LINE__,j);
                    break;
                }
                else if(j == 0)
                {
                    Manhattan_arr[0] = i;
                    Manhattan_arr[1] = j;
                    printf("%d\n",__LINE__);
                }
                else
                {
                    if( (i > 0) && ((places[i-1][j] == 'P') || 
                                   ((j > 0) && (places[i-1][j-1] == 'P') && partition_flag == false && (places[i-1][j] != 'X')) ) )
                    {  
                        save = NO;
                        printf("%d[%d]\n",__LINE__,j);
                        break;
                    }
                    else
                    {
                        save = ( ((j - Manhattan_arr[1]) <= 2) && partition_flag == false) ?  NO : YES;
                        if(save == NO)
                        {
                            printf("%d[%d]\n",__LINE__,j);
                            printf("%c\n",places[i][j]);
                            break;
                        }
                    }
                }
                partition_flag = false;
            }
            else if(places[i][j] == 'X')
            {
                printf("%d\n",__LINE__);
                partition_flag = true;
            }

        }
        
        if(save == NO)
        {
            printf("%d\n",__LINE__);
            break;
        }
        
    }
    
    return save;
}
