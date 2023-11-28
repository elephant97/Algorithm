class Solution {
    public int[] solution(int n, int s) {
        
        if(s < n) return new int[]{-1};  
        
        int remainder = s % n;
        int quotient = s / n;
        int[] answer = new int[n];
        
        
        for(int i = n-1; i >= 0; i--){// 정렬을 한번 더 안하기 위해 뒤에서 부터 나머지를 분배
            if(remainder > 0){
                answer[i] = quotient + 1;
                remainder--;
            }else{
                answer[i] = quotient;
            }
        }
        
        
        return answer;
    }
}
