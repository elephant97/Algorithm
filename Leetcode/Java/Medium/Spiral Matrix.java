class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;

        int minRow = 0;
        int maxRow = matrix.length - 1;
        int minCol = 0;
        int maxCol = matrix[0].length - 1;

        while (minRow <= maxRow && minCol <= maxCol) {
            for (int col = minCol; col <= maxCol; col++) {
                result.add(matrix[minRow][col]);
            }
            minRow++; 

            for (int row = minRow; row <= maxRow; row++) {
                result.add(matrix[row][maxCol]);
            }
            maxCol--; 

            if (minRow <= maxRow) {
                for (int col = maxCol; col >= minCol; col--) {
                    result.add(matrix[maxRow][col]);
                }
                maxRow--; 
            }

            if (minCol <= maxCol) {
                for (int row = maxRow; row >= minRow; row--) {
                    result.add(matrix[row][minCol]);
                }
                minCol++;
            }
        }

        return result;
    }
}
