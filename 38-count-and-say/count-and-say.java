class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < prev.length(); i++) {
            // If current digit is same as next one, increase count
            if (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
            } else {
                // If different digit or end of string, append count and digit to result
                result.append(count).append(prev.charAt(i));
                count = 1;
            }
        }
        
        return result.toString();
    }
}