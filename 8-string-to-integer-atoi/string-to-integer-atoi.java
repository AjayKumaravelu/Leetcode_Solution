class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Trim leading and trailing white spaces
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int i = 0;
        
        // We will initialize sign
        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // We will traverse the string
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }

            int val = ch - '0';

            // Check for overflow
            if (res > (Integer.MAX_VALUE - val) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + val;
            i++;
        }
        return res * sign;
    }
}