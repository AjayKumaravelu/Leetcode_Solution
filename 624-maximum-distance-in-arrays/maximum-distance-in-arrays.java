class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize the minimum and maximum values
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        // Iterate over each array
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int localMin = array.get(0);
            int localMax = array.get(array.size() - 1);

            // Update the maximum distance using current global min/max
            maxDistance = Math.max(maxDistance, Math.max(Math.abs(globalMax - localMin), Math.abs(localMax - globalMin)));

            // Update global min and max for future comparisons
            globalMin = Math.min(globalMin, localMin);
            globalMax = Math.max(globalMax, localMax);
        }

        return maxDistance;
    }
}