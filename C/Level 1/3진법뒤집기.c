#include <stdio.h>
#include <math.h>


int solution(int n) {
    int answer = 0;
    long i = 1, tmp = 0;
    int x = 0;
    
    while(n)
    {
        tmp += (n%3)*i;
        n = n/3;
        i *= 10;   
    }
    
    i /= 10;
    
    while(tmp)
    {
        answer += (tmp/i) * pow(3,x);
        tmp %= i;
        i /= 10;
        x++;
    }
    
    return answer;
}
