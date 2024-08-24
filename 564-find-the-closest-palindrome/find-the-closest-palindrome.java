class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long originalNumber = Long.parseLong(n);
        Set<Long> candidates = new HashSet<>();
        
        // Special case for all 9's (like 999 -> 1001)
        candidates.add((long)Math.pow(10, len) + 1); // 1000..01
        candidates.add((long)Math.pow(10, len - 1) - 1); // 999..99

        // Create palindrome by mirroring
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            String candidate = createPalindrome(Long.toString(prefix + i), len % 2 == 0);
            candidates.add(Long.parseLong(candidate));
        }
        
        candidates.remove(originalNumber); // Remove the number itself
        
        // Find the closest palindrome
        long closest = -1;
        for (long candidate : candidates) {
            if (closest == -1 ||
                Math.abs(candidate - originalNumber) < Math.abs(closest - originalNumber) ||
                (Math.abs(candidate - originalNumber) == Math.abs(closest - originalNumber) && candidate < closest)) {
                closest = candidate;
            }
        }
        
        return Long.toString(closest);
    }

    private String createPalindrome(String prefix, boolean isEven) {
        StringBuilder sb = new StringBuilder(prefix);
        if (!isEven) sb.setLength(sb.length() - 1);
        return prefix + sb.reverse().toString();
    }
}