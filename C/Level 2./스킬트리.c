#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
// skill_trees_len은 배열 skill_trees의 길이입니다.
int solution(const char* skill, const char* skill_trees[], size_t skill_trees_len) {
    int answer = 0;
    int i = 0, j = 0, x = 0;
    int check_num = 0;
    bool fail_flag = false;
    
    for(i = 0; i < skill_trees_len; i++)
    {
        check_num = 0;
        fail_flag = false;
        for(j = 0; j < strlen(skill_trees[i]); j++)
        {
            for(x = check_num; x < strlen(skill); x++)
            {
                if(skill_trees[i][j] == skill[x])
                {
                    if( (x != check_num) || ( j == 0 && x > 0))
                    {
                        fail_flag = true;
                        break;
                    }
                   
                    check_num++;
                    break;
                    
                }
            }
            
            if(fail_flag == true)
            {
                break;
            }
            else
            {
                if(j == strlen(skill_trees[i]) -1)
                {
                    answer++;
                    break;
                }
            }
        }
    }
    
       
    return answer;
}
