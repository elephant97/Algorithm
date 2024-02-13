#include <stdio.h>


// lottos_len은 배열 lottos의 길이입니다.
// win_nums_len은 배열 win_nums의 길이입니다.
int* solution(int lottos[], size_t lottos_len, int win_nums[], size_t win_nums_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(2);
    int i = 0, j = 0;
    int good = 0; //맞춘 숫자
    int dont_know_num = 0; //모르는 숫자
    int score[] = {6,6,5,4,3,2,1}; //맞춘 갯수 순서대로 들어가는 등수
    
    for(i = 0; i < lottos_len; i++)
    {
        if(lottos[i] == 0)
        {
            dont_know_num++; 
            continue;
        } 
        
        for(j = 0; j < win_nums_len; j++)
        { 
            if(lottos[i] == win_nums[j])
            {
                good++;
                break;
            } 
        }
        
    }
    
   
    answer[0] = score[good+dont_know_num];   
    answer[1] = score[good];  

    
    return answer;
}
