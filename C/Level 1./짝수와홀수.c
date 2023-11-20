#include <stdio.h>


char* solution(int num) {
    // 리턴할 값은 메모리를 동적 할당해주세요
    char* answer = (char*)malloc(sizeof(char));
    
    if(num%2 == 0)
    {
        strcpy(answer,"Even");
    }
    else
    {
        strcpy(answer,"Odd");
    }
    
    return answer;
}
