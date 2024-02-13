#include <stdio.h>

int* solution(long long n) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char tmp[sizeof(long long)] = {0,};
    int* answer = NULL;
    int i = 0, j = 0;
    
    sprintf(tmp,"%lu",n);
    answer = (int*)malloc(sizeof(int)*strlen(tmp));
    
    for(i =strlen(tmp)-1; i >= 0; i--)
    {
        answer[j] = atoi(&tmp[i]);
        tmp[i]='\0';
        j++;
    }
    
    
        
    
    return answer;
}
