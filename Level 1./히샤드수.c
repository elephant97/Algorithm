#include <stdio.h>
#include <stdbool.h>


bool solution(int x) {
    int val = 0;
    int i = 10;
    int first = 0;
    
    first = x;
    
    if((x>=1 && x<=10000) != true)
    {
        return false;
    }
    
    while(x)
    {
        val += x%i;
        x /= i;
    }   
    
    if((first%val)!=0)
    {
       return false; 
    }
    else
    {
        return true; 
    }
}
