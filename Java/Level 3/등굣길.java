class Solution {
    final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][]dp = new int[n][m];
        boolean [][]isPuddle = new boolean[n][m];

        for(int puddle[] : puddles){
            isPuddle[puddle[1] - 1][puddle[0] - 1] = true;
        }
        
        dp[0][0] = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isPuddle[i][j])  continue;
                //현재 위치 기준으로 왼쪽 윗쪽 데이터를 더함(왼쪽 윗쪽에서만 올 수 있으므로)
                if(i > 0) dp[i][j] += dp[i-1][j] % MOD;  //모듈러 연산을 해 주어야만 한다 
                if(j > 0) dp[i][j] += dp[i][j] % MOD;
            }
        }

        answer = dp[n-1][m-1] % MOD;

        return answer;
    }
}
