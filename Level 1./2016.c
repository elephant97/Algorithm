#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(int a, int b) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char *days[] = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
    int total_days[12] = {31,29,31,30,31,30,31,31,30,31,30,31};
    char* answer = (char*)malloc(sizeof(char)*3+1);
    int i = 0, answer_helper = 0;
    
    memset(answer,0x00,sizeof(char)*3+1);
    
    for(i = 0; i < a-1; i++)
    {
        answer_helper += total_days[i];
    }
    
    strcpy(answer,days[(answer_helper+(b-1))%7]);
    
    return answer;
}
