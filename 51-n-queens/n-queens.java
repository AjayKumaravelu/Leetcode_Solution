class Solution {
    public void solve(int col, char[][] board, int[] leftrow, int[] upperdiagonal, int[] lowerdiagonal, List<List<String>> ans){
        // Base condition when the col pointer goes out of index
        if(col == board.length){
            ans.add(construct(board));
            return;
        }

        // we will traverse all the row of 1 column
        for(int row = 0; row < board.length; row++){
            if(leftrow[row] == 0 && lowerdiagonal[row + col] == 0 && upperdiagonal[board.length - 1 +  col - row] == 0){
                // we will update the board
                board[row][col] = 'Q';
                // we will update the leftrow, lowerdiagonal, upperdiagonal
                leftrow[row] = 1;
                lowerdiagonal[row + col] = 1;
                upperdiagonal[board.length - 1 + col - row] = 1;

                // we call for next column
                solve(col + 1, board, leftrow, upperdiagonal,lowerdiagonal, ans);

                // In backtracking we will make the change to normal
                board[row][col] = '.';
                leftrow[row] = 0;
                lowerdiagonal[row + col] = 0;
                upperdiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    public List<List<String>> solveNQueens(int n) {
        // We want board to keep track of the board and we will initialize it with "."
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        // we want answer list to store the answer from the board
        List<List<String>> ans = new ArrayList<>();

        // For row we will create one array likewise for upper diagonal and lower diagonal
        int[] leftrow = new int[n];
        int[] upperdiagonal = new int[2*n - 1];
        int[] lowerdiagonal = new int[2*n - 1];

        solve(0, board, leftrow, upperdiagonal, lowerdiagonal, ans);
        return ans; 
    }
}