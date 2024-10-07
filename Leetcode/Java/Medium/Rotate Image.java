class Solution {
    public void rotate(int[][] matrix) {
        int[][] rotateMatrix = new int[matrix.length][matrix[0].length];
        int row = 0;

        for(int j = 0; j < matrix.length; j++){
            int col = 0;
            for(int i = matrix.length-1; i >= 0; i--){
                rotateMatrix[row][col] = matrix[i][j];
                col++;
            }
            row++;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = rotateMatrix[i].clone();
        }
    }
}
