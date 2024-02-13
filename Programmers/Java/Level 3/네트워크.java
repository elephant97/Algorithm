class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        //int [][]visit = new int[n][n]; // 굳이 2중배열이 아니라 일차원 배열로 해서 해당 행 체크했는지만 체크하면 됨
        boolean []visit = new boolean[n];
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(visit[i] == false && computers[i][j] == 1)
                {
                    dfs(computers, visit, j);
                    answer++;
                }
                    
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, boolean[] visit, int node){
        visit[node] = true;
        
        for(int j = 0; j < computers.length; j++){
            if(computers[node][j] == 1 && visit[j] == false){
                dfs(computers, visit, j); 
            }
        }
    }
    
   
}
