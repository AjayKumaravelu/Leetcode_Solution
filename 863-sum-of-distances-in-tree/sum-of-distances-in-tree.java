class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] count = new int[n];
        int[] answer = new int[n];

        // Perform DFS to calculate count and answer arrays
        dfs1(0, -1, tree, count, answer);
        dfs2(0, -1, tree, count, answer);

        return answer;
    }

    private void dfs1(int node, int parent, List<List<Integer>> tree, int[] count, int[] answer) {
        count[node] = 1;
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs1(child, node, tree, count, answer);
                count[node] += count[child];
                answer[node] += answer[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent, List<List<Integer>> tree, int[] count, int[] answer) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                answer[child] = answer[node] - count[child] + tree.size() - count[child];
                dfs2(child, node, tree, count, answer);
            }
        }
    }
    
}