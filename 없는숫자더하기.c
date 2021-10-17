#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// numbers_len은 배열 numbers의 길이입니다.
int solution(int numbers[], size_t numbers_len) {
    int answer = 0;
    int i = 0, j = 0;
    
    for(j = 0; j < 10; j++)
    {
        answer += j;
    }

    for(j = 0; j < numbers_len; j++)
    {
        answer -= numbers[j];
    }

    return answer;
}
