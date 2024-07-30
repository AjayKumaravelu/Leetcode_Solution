class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        // `bCount` will store the number of 'b's encountered so far
        int bCount = 0;
        // `minDeletions` will store the minimum deletions needed to make the string balanced
        int minDeletions = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else { // s.charAt(i) == 'a'
                if (bCount > 0) {
                    // Either delete this 'a' or some previous 'b's
                    minDeletions++;
                    // Consider this 'a' as deleted, so decrement bCount
                    bCount--;
                }
            }
        }

        return minDeletions;
    }
}