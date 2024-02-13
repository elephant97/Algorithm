#include <stdio.h>
#include <stdbool.h>
#include <math.h>

bool check(int a) //소수 판별
{
    bool answer = true;
    
    if(a == 1 ) return false;
    if(a == 2 ) return answer;
    
    for(int i = 2; i <= sqrt(a); i++)
    {
        if(a%i == 0)
        {
            answer = false; 
            break;
        }
    }
    
    return answer;
}

// nums_len은 배열 nums의 길이입니다.
int solution(int nums[], size_t nums_len) {
    int answer = 0;
    int x = 0, y = 0, z = 0;
    int sum = 0;
    
    
    for(x = 0; x < nums_len-2; x++)
    {
        for(y = x+1; y < nums_len-1; y++)
        {
            for(z = y+1; z < nums_len; z++)
            {
                sum = nums[x]+nums[y]+nums[z];
                if(check(sum) == true) answer++;
            }
        }
    }
    
    return answer;
}
