class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // Step 1: Calculate the degree of each city
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // Step 2: Create a list of cities with their degrees
        List<int[]> cityDegreeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cityDegreeList.add(new int[]{i, degree[i]});
        }

        // Step 3: Sort cities by their degrees in descending order
        Collections.sort(cityDegreeList, (a, b) -> b[1] - a[1]);

        // Step 4: Assign values to cities based on their sorted order
        int[] cityValues = new int[n];
        int value = n;
        for (int[] city : cityDegreeList) {
            cityValues[city[0]] = value--;
        }

        // Step 5: Calculate the total importance of all roads
        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += (long) cityValues[road[0]] + cityValues[road[1]];
        }

        return totalImportance;
    }
}