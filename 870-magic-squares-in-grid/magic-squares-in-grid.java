class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        // Traverse through the grid to find all possible 3x3 subgrids
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if all numbers in the 3x3 grid are distinct and within the range [1, 9]
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        // Check if the sums of rows, columns, and diagonals are equal to 15
        int sum1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int sum2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int sum3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];
        int sum4 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int sum5 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int sum6 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];
        int sum7 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum8 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];

        return (sum1 == 15 && sum2 == 15 && sum3 == 15 &&
                sum4 == 15 && sum5 == 15 && sum6 == 15 &&
                sum7 == 15 && sum8 == 15);
    }
}