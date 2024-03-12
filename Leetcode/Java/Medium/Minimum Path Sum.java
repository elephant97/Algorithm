class Solution {
    int m;
    int n; 
    int[][] dp;
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for(int i = 1; i < n; i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        

        for(int i = 1; i < m; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);
            }
        }

        return dp[m-1][n-1];
    }
    
}
