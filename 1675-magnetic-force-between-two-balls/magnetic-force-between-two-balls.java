class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0];
        
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canPlaceBalls(position, m, mid)) {
                left = mid; // Try for a larger force
            } else {
                right = mid - 1; // Try for a smaller force
            }
        }
        
        return left;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int minForce) {
        int count = 1; // Place the first ball
        int lastPos = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minForce) {
                count++;
                lastPos = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        
        return false;
    }
}