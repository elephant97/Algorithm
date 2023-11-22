class Solution {
    public String solution(String s) {
        String answer = "";
        String splitS[] = s.split(" ");
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; //반대로 초기화 해야 정답을 찾을 수 있음
        
        for(String data : splitS)
        {
            int number = Integer.parseInt(data);
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        answer = min+" "+max;
        return answer;
    }
}
