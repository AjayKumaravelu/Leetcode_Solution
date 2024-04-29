class Solution {
    public int minOperations(int[] nums, int k) {
        return popcount(Arrays.stream(nums).reduce(k, (x, y) -> x ^ y));
    }
    
    private int popcount(int x) {
        return Integer.bitCount(x);
    }
}