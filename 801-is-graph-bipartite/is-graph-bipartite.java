class Solution {
    private boolean dfs(int start,int col, int[] color, int[][] graph){
        color[start] = col;

        // traverse the graph
        for(int it: graph[start]){
            if(color[it] == -1){
                if (dfs(it, 1 - col, color, graph) == false)
                    return false;
            }
            else if(color[it] == col)
                return false;
        }
        return true;
    }

    private boolean check(int start, int v, int[][] graph, int[] color){
        // using bfs so we are using queue
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int it: graph[node]){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;

    }

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        // initialising the color
        for(int i = 0; i < v; i++){
            color[i] = -1;
        }

        // Checking for all the components
        for(int i = 0; i < v; i++){
            if(color[i] == -1)
                if (dfs(i,0,color,graph) == false)
                    return false;
        }
        return true;
    }
}