class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n == 1) {
            result.add(0); // Only one node, so it's the root of the MHT
            return result;
        }

        // Build the graph representation
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Initialize a queue with leaf nodes (nodes with only one neighbor)
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        // Iterate until there are less than or equal to 2 nodes remaining
        while (n > 2) {
            int size = leaves.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                int neighbor = graph.get(leaf).iterator().next(); // Get the only neighbor
                graph.get(neighbor).remove(leaf); // Remove leaf from its neighbor's neighbors
                if (graph.get(neighbor).size() == 1) {
                    leaves.offer(neighbor); // Add new leaf nodes
                }
            }
        }

        // At this point, the remaining nodes in 'leaves' are the roots of MHTs
        result.addAll(leaves);
        return result;
    }
}