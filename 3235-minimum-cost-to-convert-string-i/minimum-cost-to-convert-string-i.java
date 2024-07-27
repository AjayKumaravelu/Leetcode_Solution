class Solution {
    private static final int INF = 1000000000; 
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26; // Number of lowercase English letters
        int[][] minCost = new int[n][n];
        
        // Initialize the cost matrix with infinity, except diagonal elements
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], INF);
            minCost[i][i] = 0;
        }

        // Populate the cost matrix with given transformations
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            minCost[u][v] = Math.min(minCost[u][v], cost[i]);
        }

        // Floyd-Warshall algorithm to find shortest paths between all pairs of nodes
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (minCost[i][k] < INF && minCost[k][j] < INF) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }

        long totalCost = 0;
        // Calculate the minimum cost to convert each character in source to target
        for (int i = 0; i < source.length(); i++) {
            int srcChar = source.charAt(i) - 'a';
            int tgtChar = target.charAt(i) - 'a';
            if (minCost[srcChar][tgtChar] == INF) {
                return -1; // If any character cannot be transformed, return -1
            }
            totalCost += minCost[srcChar][tgtChar];
        }

        return totalCost;
    }
}