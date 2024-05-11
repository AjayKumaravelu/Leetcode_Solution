class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] ratio = new double[n][2]; // ratio[i][0] = wage/quality, ratio[i][1] = quality
        for (int i = 0; i < n; i++) {
            ratio[i][0] = (double) wage[i] / quality[i];
            ratio[i][1] = quality[i];
        }
        
        // Sort the workers based on their wage/quality ratio
        Arrays.sort(ratio, (a, b) -> Double.compare(a[0], b[0]));
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(k, (a, b) -> Double.compare(b, a));
        double qualitySum = 0;
        for (int i = 0; i < k - 1; i++) {
            qualitySum += ratio[i][1];
            maxHeap.offer(ratio[i][1]);
        }
        
        double minCost = Double.MAX_VALUE;
        for (int i = k - 1; i < n; i++) {
            qualitySum += ratio[i][1];
            maxHeap.offer(ratio[i][1]);
            minCost = Math.min(minCost, ratio[i][0] * qualitySum);
            qualitySum -= maxHeap.poll();
        }
        
        return minCost;
    }
}