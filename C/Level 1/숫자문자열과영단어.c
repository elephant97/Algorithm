#include <stdio.h>

void cut_string(char *string, int location, int total_lenth);

int solution(const char* s) {
    char eng_num[][10]={"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    int i = 0,j = 0, x = 0;
    char answer_string[50]={0,};

  
    for(; i<strlen(s); )
    {
        for(j=0; j<10; j++)
        {    
            if(s[0] == eng_num[j][0])
            {    
                if(!strncmp(eng_num[j],s,strlen(eng_num[j])))
                {
                    cut_string(s,strlen(eng_num[j]),strlen(s));       
                    if(strlen(answer_string) <= 0)
                    {
                        sprintf(answer_string,"%d",j);
                    }
                    else
                    {
                        sprintf(answer_string,"%s%d",answer_string,j);
                    }
                    break;
                }
            }  
        }
        
        if(j == 10)
        {
            if(strlen(answer_string) <= 0)
            {
                sprintf(answer_string,"%c",s[0]);
            }
            else
            {
                sprintf(answer_string,"%s%c",answer_string,s[0]);
            }
            cut_string(s, 1, strlen(s));
        }         
    }
    
    return atoi(answer_string);
}

void cut_string(char *string, int location, int total_lenth)
{
    int i =0;
    
    if((total_lenth-location)<=0)
        string[0]='\0';
    
    for(i=0; i<(total_lenth-location); i++)
    {
        string[i] = string[i+location];
    }
    string[total_lenth-location]='\0';   
    
    
}
