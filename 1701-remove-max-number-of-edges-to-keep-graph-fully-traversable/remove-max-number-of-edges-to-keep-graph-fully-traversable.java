class Solution {
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            count = n;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            count--;
            return true;
        }

        public int getCount() {
            return count;
        }
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int edgesUsed = 0;

        // Use type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }

        // Use type 1 edges for Alice
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (alice.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }

        // Use type 2 edges for Bob
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (bob.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }

        // Check if both Alice and Bob can traverse the entire graph
        if (alice.getCount() != 1 || bob.getCount() != 1) {
            return -1;
        }

        return edges.length - edgesUsed;
    }
}