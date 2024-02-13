class Solution {
    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length()-1;
        
        for(int i=0;i<name.length();i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);//위로 찾는것과 아래로 찾는 것을 비교
            
            index = i+1;
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            move = Math.min(move, i*2+name.length()-index); //앞에서부터 시작했다가 돌아오는 경우
            move = Math.min(move, (name.length()-index)*2 + i); //뒤부터 시작했다가 돌아오는 경우
        }
        return answer + move;
    }
}
