class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (n + m); // total sum of all n + m rolls
        int currentSum = 0;
        
        // Calculate the sum of the m given rolls
        for (int roll : rolls) {
            currentSum += roll;
        }
        
        // Calculate the required sum for the missing n rolls
        int missingSum = totalSum - currentSum;
        
        // Check if the required sum is possible
        if (missingSum < n || missingSum > 6 * n) {
            return new int[] {}; // No solution, return an empty array
        }
        
        // Initialize the result array for the missing observations
        int[] result = new int[n];
        
        // Distribute the missing sum across n rolls
        int quotient = missingSum / n; // Base value for each missing roll
        int remainder = missingSum % n; // Remainder to be distributed
        
        // Fill the result array
        for (int i = 0; i < n; i++) {
            result[i] = quotient + (i < remainder ? 1 : 0);
        }
        
        return result;
    }
}