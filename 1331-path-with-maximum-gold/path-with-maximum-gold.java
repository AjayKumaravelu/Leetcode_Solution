class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, backtrack(grid, i, j));
                }
            }
        }
        return maxGold;
    }
    
    private int backtrack(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        
        int original = grid[row][col];
        grid[row][col] = 0; // Mark as visited
        
        int maxGold = 0;
        maxGold = Math.max(maxGold, backtrack(grid, row + 1, col)); // Down
        maxGold = Math.max(maxGold, backtrack(grid, row - 1, col)); // Up
        maxGold = Math.max(maxGold, backtrack(grid, row, col + 1)); // Right
        maxGold = Math.max(maxGold, backtrack(grid, row, col - 1)); // Left
        
        grid[row][col] = original; // Restore original value
        return maxGold + original;
    }
}