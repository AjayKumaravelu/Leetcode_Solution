class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];

        // Create an array of projects with capital and profit
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort the projects based on the required capital
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        // Max-heap to store the profits of the projects we can afford
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int i = 0;
        while (k > 0) {
            // Add all projects that can be afforded with the current capital to the max-heap
            while (i < n && projects[i][0] <= w) {
                maxHeap.add(projects[i][1]);
                i++;
            }

            // If there are no projects we can afford, break the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the project with the maximum profit
            w += maxHeap.poll();
            k--;
        }

        return w;
    }
}