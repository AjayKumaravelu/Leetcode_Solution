class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        // Sort jobs by their difficulty
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        // Sort worker abilities
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int best = 0;
        int i = 0;
        
        // For each worker, find the most profitable job they can do
        for (int ability : worker) {
            // While the worker can perform the job, update the best profit
            while (i < n && ability >= jobs[i][0]) {
                best = Math.max(best, jobs[i][1]);
                i++;
            }
            maxProfit += best;
        }
        
        return maxProfit;
    }
}