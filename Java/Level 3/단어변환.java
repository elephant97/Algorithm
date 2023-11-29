// 예를 들어 begin이 "hit", target가 "cog", words가 
// ["hot","dot","dog","lot","log","cog"]라면 
// "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
class Solution {
    boolean[] visited;
    int answer = -1;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        checkTargetInArray(begin, target, words);// 배열 안에 target이 존재하는지 확인
        if(answer != -1) return answer;

        dfs(begin, target, words, 0);
        
        return answer;
    }

    void dfs(String begin, String target, String[] words, int visitCnt){

        if(target.equals(begin)) {
            if(answer > visitCnt || answer == -1) answer = visitCnt;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            int diffCnt = 0;

            if(visited[i]) continue;

            for(int j = 0; j < words[i].length() && diffCnt <= 1; j++){
                if(begin.charAt(j) != words[i].charAt(j)){
                    diffCnt++;
                }
            }

            if(diffCnt <= 1){
                System.out.println(begin +" "+words[i]);
                visited[i] = true;
                dfs(words[i], target, words, visitCnt+1);
                visited[i] = false; //완전 탐색을 위해 탐색이 끝난 후 false로 변경
            }
        }
    }

    void checkTargetInArray(String begin, String target, String[] words){
        
        for(int i = 0; i < words.length; i++){
            int targetDiffCnt = 0;
            if(target.equals(words[i]))
            {
                for(int j = 0; j < target.length(); j++){
                    if(begin.charAt(j) != target.charAt(j)){
                        targetDiffCnt++;
                    }
                }
                
                if(targetDiffCnt == 1){//한개만 다를 시 바로 변환 가능
                    answer = 1;
                } 

                return; 
            }
        }

        answer = 0;
    }
}
