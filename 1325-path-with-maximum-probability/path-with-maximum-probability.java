import java.util.*;

public class Solution {
    class Pair {
        int node;
        double prob;
        
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Graph represented as an adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }
        
        // Max heap to use in Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double[] probabilities = new double[n];
        probabilities[start] = 1.0;
        
        pq.offer(new Pair(start, 1.0));
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;
            double currentProb = current.prob;
            
            // If we reached the end node, return the probability
            if (currentNode == end) {
                return currentProb;
            }
            
            // Explore neighbors
            for (Pair neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.node;
                double nextProb = neighbor.prob;
                double newProb = currentProb * nextProb;
                
                // If the new probability is greater, update and push to the priority queue
                if (newProb > probabilities[nextNode]) {
                    probabilities[nextNode] = newProb;
                    pq.offer(new Pair(nextNode, newProb));
                }
            }
        }
        
        // If no path found, return 0
        return 0.0;
    }
}
