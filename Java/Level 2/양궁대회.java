class Solution {
    int[] lion = new int[11];
    int[] answer = new int[]{-1};
    int max;
    int[] info;
    int n;
    
    public int[] solution(int n, int[] info) {
        
        this.n = n;
        this.info = info;
        dfs(1);
        return answer;
    }
    
    void dfs(int cnt){
        
        if(cnt > n){
            checkMax(info);
            return;
        } 
            
        for(int i = 0; i < 11 && lion[i] <= info[i]; i++){
            lion[i]++;
            dfs(cnt+1);
            lion[i]--;
        }
        
    }
    
    void checkMax(int[] info){
        int apeachSum = 0;
        int lionSum = 0;
        
        //합계 
        for(int i = 0; i < 11; i++){
            if(info[i] == 0 && lion[i] == 0) continue;
            
            if(info[i] < lion[i]) lionSum += (10 - i);
            else apeachSum += (10 - i);
        }

        if(apeachSum < lionSum && max <= (lionSum-apeachSum)){
            answer = lion.clone();
            max = lionSum-apeachSum;
        }
    }
}
