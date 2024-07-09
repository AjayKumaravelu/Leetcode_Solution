class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        int currentTime = 0;
        
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookingTime = customer[1];
            
            // If the chef is idle when the customer arrives, start cooking immediately.
            currentTime = Math.max(currentTime, arrivalTime);
            
            // The customer has to wait until the chef finishes cooking their order.
            totalWaitingTime += (currentTime + cookingTime - arrivalTime);
            
            // Update the current time to when the chef will finish this customer's order.
            currentTime += cookingTime;
        }
        
        return (double) totalWaitingTime / customers.length;
    }
}