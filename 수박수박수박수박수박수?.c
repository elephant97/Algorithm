#include <stdio.h>


char* solution(int n) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char* answer = (char*)malloc(sizeof(char)*n*3); 
    char *su = "수";
    char *bak = "박";
    int i = 0;
    
    
    memset(answer,0x00,sizeof(answer));
    
    strcat(answer,su);
    
    for(i = 1; i<n; i++)
    {
        if((i%2) == 0)
        {
           strcat(answer,su);
        }
        else
        {
            strcat(answer,bak);
        }
    }
  
  
    answer[strlen(answer)]='\0';
    
    return answer;
}
