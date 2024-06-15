class Solution {
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int R = m - 1;
        double result = 1;

        // finding combination
        for(int i = 1; i <= R; i++){
            result = result * (N -  R + i)/i;
        }

        return (int)result;
    }
}