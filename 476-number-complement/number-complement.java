class Solution {
    public int findComplement(int num) {
        int bitLength = Integer.toBinaryString(num).length();
        
        // Create a mask that has all bits set to 1 for the length of the binary representation
        int mask = (1 << bitLength) - 1;
        
        // XOR the num with the mask to get the complement
        return num ^ mask;
    }
}