class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLength = 0;
        boolean oddPresent = false;
        
        for(char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        for(int freq : freqMap.values()) {
            if(freq % 2 == 0) {
                maxLength += freq;
            } else {
                maxLength += freq - 1;
                oddPresent = true;
            }
        }
        
        return oddPresent ? maxLength + 1 : maxLength;
    }
}