#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int compare(const void* a, const void* b)
{
    int num1 = *(int *)a;
    int num2 = *(int *)b;
    char strbuf_1[8+1] = {0,};
    char strbuf_2[8+1] = {0,};
    
    sprintf(strbuf_1,"%d%d",num1,num2);
    sprintf(strbuf_2,"%d%d",num2,num1);

    return strcmp(strbuf_2,strbuf_1); //내림차순으로 정렬해야 하므로 비교 순서를 바꿈
}

// numbers_len은 배열 numbers의 길이입니다.
char* solution(int numbers[], size_t numbers_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char *)malloc(sizeof(int)*numbers_len+1);
    int i = 0;

    memset(answer, 0x00, sizeof(int)*numbers_len+1);
    
    qsort(numbers,numbers_len,sizeof(int),compare);
    
    sprintf(answer, "%d",numbers[0]);
    
    if(numbers[0] != 0)
    {   
        for(i = 1; i < numbers_len; i++)
        {
            sprintf(answer,"%s%d", answer, numbers[i]);
        }
    }
    
    return answer;
}
