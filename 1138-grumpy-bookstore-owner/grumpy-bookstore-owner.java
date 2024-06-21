class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int baseSatisfied = 0;

        // Calculate the base number of satisfied customers without any technique
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                baseSatisfied += customers[i];
            }
        }

        // Use sliding window to calculate the maximum additional satisfied customers
        int maxAdditionalSatisfied = 0;
        int currentAdditionalSatisfied = 0;

        // Calculate the additional satisfied customers for the initial window
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
        }
        maxAdditionalSatisfied = currentAdditionalSatisfied;

        // Slide the window across the array
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentAdditionalSatisfied -= customers[i - minutes];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, currentAdditionalSatisfied);
        }

        // The total number of satisfied customers is the base satisfied plus the maximum additional satisfied
        return baseSatisfied + maxAdditionalSatisfied;
    }
}