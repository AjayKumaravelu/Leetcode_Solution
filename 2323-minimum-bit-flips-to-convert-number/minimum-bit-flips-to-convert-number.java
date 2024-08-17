class Solution {
    public int minBitFlips(int start, int goal) {
        // These tells about the number of bits which is different
        int diffBits = start ^ goal;
        int flipCount = 0;

        while(diffBits != 0){
            flipCount += diffBits & 1;
            diffBits = diffBits >> 1; 
        }
        
        return flipCount;
    }
}