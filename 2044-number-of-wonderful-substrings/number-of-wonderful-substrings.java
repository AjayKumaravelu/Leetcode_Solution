class Solution {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        long count = 0;
        long[] freq = new long[1024]; // Bitmask for 10 lowercase letters
        freq[0] = 1;

        int bitmask = 0;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int charIndex = c - 'a';

            bitmask ^= (1 << charIndex);

            count += freq[bitmask];

            for (int j = 0; j < 10; j++) {
                count += freq[bitmask ^ (1 << j)];
            }

            freq[bitmask]++;
        }

        return count;
    }
}