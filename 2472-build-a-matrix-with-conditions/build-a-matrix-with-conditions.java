class Solution {
    private List<Integer> topologicalSort(int k, List<Integer>[] graph, int[] indegree) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return order;
    }
    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Create graphs for row and column conditions
        List<Integer>[] rowGraph = new ArrayList[k + 1];
        List<Integer>[] colGraph = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            rowGraph[i] = new ArrayList<>();
            colGraph[i] = new ArrayList<>();
        }
        
        int[] rowIndegree = new int[k + 1];
        int[] colIndegree = new int[k + 1];
        
        // Fill graphs and calculate indegrees
        for (int[] condition : rowConditions) {
            rowGraph[condition[0]].add(condition[1]);
            rowIndegree[condition[1]]++;
        }
        for (int[] condition : colConditions) {
            colGraph[condition[0]].add(condition[1]);
            colIndegree[condition[1]]++;
        }
        
        // Perform topological sorting
        List<Integer> rowOrder = topologicalSort(k, rowGraph, rowIndegree);
        List<Integer> colOrder = topologicalSort(k, colGraph, colIndegree);
        
        if (rowOrder.size() < k || colOrder.size() < k) {
            return new int[0][0];
        }
        
        // Create the matrix
        int[][] matrix = new int[k][k];
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }
        
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        
        return matrix;
    }
}