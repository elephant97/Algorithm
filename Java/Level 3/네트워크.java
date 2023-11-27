class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int [][]visit = new int[n][n];
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(visit[i][j] == 0 && computers[i][j] == 1)
                {
                    dfs(computers, visit, j);
                    answer++;
                }
                    
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int[][] visit, int node){
        
        for(int j = 0; j < computers.length; j++){
            if(computers[node][j] == 1 && visit[node][j] == 0){
                visit[node][j] = 1;
                dfs(computers, visit, j);
            }
        }
    }
    
}
