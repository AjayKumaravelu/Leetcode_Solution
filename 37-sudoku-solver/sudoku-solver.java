class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;

                            if(solve(board) == true){
                                return true;
                            } //else backtrack if it false
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < board.length; i++){
            // we are traversing row
            if(board[row][i] == c){
                return false;
            }
            // we are traversing column
            if(board[i][col] == c){
                return false;
            }
            // We are checking 3*3 matrix
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c){
                return false;
            }
        }
        return true;
    }
}