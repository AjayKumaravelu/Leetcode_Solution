class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    // Check if the current island is a sub-island
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;
        
        // If out of bounds or the cell is water, return true (base case for recursion)
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true;
        }
        
        // If this part of grid2 is land, but grid1 is water, it's not a sub-island
        if (grid1[i][j] == 0) {
            return false;
        }
        
        // Mark the cell as visited by setting it to 0
        grid2[i][j] = 0;
        
        // Check all four directions
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);
        
        // The current island is a sub-island only if all parts are sub-islands
        return up && down && left && right;
    }
}
