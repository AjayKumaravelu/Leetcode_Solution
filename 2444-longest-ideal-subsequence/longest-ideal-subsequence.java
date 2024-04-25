class Solution {
    public int longestIdealString(String s, int k) {
         int n = s.length();
        Map<Integer, Integer> dp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int currChar = s.charAt(i) - 'a';
            int maxLength = 0;
            for (int j = currChar - k; j <= currChar + k; j++) {
                if (dp.containsKey(j)) {
                    maxLength = Math.max(maxLength, dp.get(j));
                }
            }
            dp.put(currChar, maxLength + 1);
        }

        int max = 0;
        for (int length : dp.values()) {
            max = Math.max(max, length);
        }
        return max;
    }
}