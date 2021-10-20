#include <stdio.h>

// numbers_len은 배열 numbers의 길이입니다.
int* solution(int numbers[], size_t numbers_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
   
    int i = 0, j = 0, x = 0, y = 0;  
    int cnt = (numbers_len*(numbers_len-1))/2;
    int* answer = (int*)malloc(sizeof(int)*cnt);
    int tmp=0;

    
    memset(answer,0,sizeof(int)*cnt);
    
    for(i=0; i< numbers_len-1; i++)
    {      
        for(j=i+1; j<numbers_len; j++)
        {     
            for(y=0; y<=x; y++)
            {
                if(x == y)
                {
                    answer[x] = numbers[i] + numbers[j];
                    x++;
                    break;
                }
                else if((answer[y] == (numbers[i] + numbers[j])))
                {
                    break;
                }
            }
            
        }
    }
    
    for(i=0; i<(x-1); i++)
    {
        for(j=i+1; j<x; j++)
        {
            if(answer[i] > answer[j])
            {
                tmp = answer[i];
                answer[i] = answer[j];
                answer[j] = tmp;
            }
        }  
    }
    
  
    
    return answer;
}
