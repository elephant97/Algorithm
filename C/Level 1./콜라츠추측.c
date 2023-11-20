#include <stdio.h>

int solution(int num) {
    int answer = 0;
    int cnt = 0;
    long long val = 0; 
    
    val = num;
    
    if(num == 1)
    {
        return 0;
    }
    
    while(1)
    {
        cnt++;
        
        if( (val%2) != 0 )
        {
            val = (val*3)+1;    
        }
        else
        {
            val /= 2;
        }
        
        if(val == 1 || cnt == 500) break;
        
    }
    
   
    
    if(cnt == 500)
    {
        answer = -1;
    }
    else 
    {
        answer = cnt;
    }
    
    return answer;
}
