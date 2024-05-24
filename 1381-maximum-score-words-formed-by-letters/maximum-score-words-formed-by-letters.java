class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] wordScores = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordScores[i] += score[c - 'a'];
            }
        }

        // Step 2: Count the available letters
        int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }

        // Step 3: Backtracking to explore all combinations
        return backtrack(words, wordScores, letterCount, 0);
    }

    private int backtrack(String[] words, int[] wordScores, int[] letterCount, int index) {
        if (index == words.length) {
            return 0;
        }

        // Skip the current word
        int maxScore = backtrack(words, wordScores, letterCount, index + 1);

        // Try to use the current word if possible
        String word = words[index];
        boolean canUseWord = true;
        int[] tempCount = new int[26];
        for (char c : word.toCharArray()) {
            tempCount[c - 'a']++;
            if (tempCount[c - 'a'] > letterCount[c - 'a']) {
                canUseWord = false;
                break;
            }
        }

        if (canUseWord) {
            // Use the current word
            for (char c : word.toCharArray()) {
                letterCount[c - 'a']--;
            }
            maxScore = Math.max(maxScore, wordScores[index] + backtrack(words, wordScores, letterCount, index + 1));
            // Backtrack: restore the letter count
            for (char c : word.toCharArray()) {
                letterCount[c - 'a']++;
            }
        }

        return maxScore;
    }
}