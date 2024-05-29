class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        
        // Start from the end of the string and move towards the start
        for (int i = s.length() - 1; i > 0; i--) {
            // If there's a carry, consider the current bit as (bit + carry)
            if (s.charAt(i) - '0' + carry == 1) {
                // If it's odd, we add 1 (making it even) and increment the carry
                carry = 1;
                steps += 2; // one step for +1 (making it even), one step for dividing by 2
            } else {
                // If it's even, just divide by 2 (one step)
                steps += 1;
            }
        }
        
        // For the leftmost bit (which is always 1), if there's a carry, one more step is needed
        return steps + carry;
    }
}