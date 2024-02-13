#include <stdio.h>


#define SWAP(a,b) {int c = a; a=b; b=c;} 

long long solution(int a, int b) {
    long long answer = 0;
    int i = 0;
   
    
    if(b < a)
    {
        SWAP(a,b);
    }
    
    if(a != b)
    {
        for(i = a; i<=b; i++)
        {
            answer += i;
        }
    }
    else
    {
        answer = a;
    }
    
    
    return answer;
}
