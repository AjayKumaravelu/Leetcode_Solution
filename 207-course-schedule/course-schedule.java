class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second; 
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i, adj, visited, recStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclic(int curr, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        if (recStack[curr]) {
            return true; // If the node is already in the current path, there is a cycle
        }
        if (visited[curr]) {
            return false; // If the node is already visited, no cycle detected in this path
        }

        visited[curr] = true;
        recStack[curr] = true;

        for (int neighbor : adj.get(curr)) {
            if (isCyclic(neighbor, adj, visited, recStack)) {
                return true;
            }
        }

        recStack[curr] = false;
        return false;

    }
}