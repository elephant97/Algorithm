class Solution {
    int m;
    int n;

    public int numIslands(char[][] grid) {
        int answer = 0;
        m = grid.length;
        n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    public void dfs(char[][] grid, int row, int col) {

        if (grid[row][col] != '1' ) return;

        grid[row][col] = '2';
        
        if(row+1 < m )
            dfs(grid, row + 1, col);
        if(row-1 >= 0)
            dfs(grid, row - 1, col);
        if(n > col+1)
            dfs(grid, row,     col+1);
        if(0 <= col-1)
            dfs(grid, row,     col-1);
    }
}
