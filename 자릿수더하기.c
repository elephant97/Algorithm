#include <stdio.h>


int solution(int n) {
    int answer = 0;
    int temp = 0;
    int value = 10;
    
    while(n)
    {
        temp = n%10;
        answer += temp;
        n = n/10;
    }
    
    
    return answer;
}
