class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean [] smallSquareIsValid = new boolean[9];
        HashSet<Character>[] rowValid = new HashSet[9];  
        HashSet<Character>[] colValid = new HashSet[9];

        for(int row = 0; row < 9; row++){
            rowValid[row] = new HashSet<>();
            for(int col = 0; col < 9; col++){
                if(row == 0) colValid[col] = new HashSet<>();
                
                int squareIndex = (row / 3) * 3 + col / 3;
                if(!smallSquareIsValid[squareIndex]){
                    HashSet<Character> smallSquare = new HashSet<>();
                    
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            if(board[row+i][col+j] == '.') continue;
                            if(smallSquare.contains(board[row+i][col+j])){
                                return false;
                            } 
                            smallSquare.add(board[row+i][col+j]);
                        }
                    }
                    smallSquareIsValid[squareIndex] = true;
                }

                if(board[row][col] == '.') continue;
                
                if(colValid[col].contains(board[row][col]) || rowValid[row].contains(board[row][col])) return false;
                
                colValid[col].add(board[row][col]);
                rowValid[row].add(board[row][col]);
            }
        }
        
        return true;
    }
}
