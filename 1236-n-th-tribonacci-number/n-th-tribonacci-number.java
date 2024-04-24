class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        // Initialize the first three terms of the Tribonacci sequence
        int T0 = 0, T1 = 1, T2 = 1;

        // Iterate to calculate the nth term
        for (int i = 3; i <= n; i++) {
            int T3 = T0 + T1 + T2;
            T0 = T1;
            T1 = T2;
            T2 = T3;
        }

        return T2;
    }
}