class Solution {
    public String solution(String s) {
        String splitS[] = s.split(" "); //공백 기준으로 split했기 떄문에, 공백은 사라짐
        String answer = "";
        
        for(int i = 0; i < splitS.length; i++){
            
            if(splitS[i].length() <= 0){
                answer += " ";
                continue;  
            } 
            answer += splitS[i].substring(0,1).toUpperCase();
            answer += splitS[i].substring(1,splitS[i].length()).toLowerCase();
            if( i+1 == splitS.length) break;
            answer += " ";
        }
        
        //맨 뒤에 공백이 있는 경우 카운팅이 되지 않으므로, 별도로 기존 문자열의 길이를 비교하여 채워줌
        int blank = s.length() - answer.length();
        for(int i = 0; i < blank; i++)
            answer += " ";
        
        return answer;
    }
}