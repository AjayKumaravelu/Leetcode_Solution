class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(stones, i, visited);
            }
        }

        // Total stones minus the number of connected components gives us the maximum number of stones that can be removed.
        return n - components;
    }

    private void dfs(int[][] stones, int currentIndex, boolean[] visited) {
        visited[currentIndex] = true;

        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] && (stones[i][0] == stones[currentIndex][0] || stones[i][1] == stones[currentIndex][1])) {
                dfs(stones, i, visited);
            }
        }
    }
}