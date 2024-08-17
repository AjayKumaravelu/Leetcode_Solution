class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        // Using Bitwise operator
        if((n & n-1) == 0) return true;
        else return false;
    }
}