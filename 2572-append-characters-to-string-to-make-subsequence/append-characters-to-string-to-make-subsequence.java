class Solution {
    public int appendCharacters(String s, String t) {
        int sIndex = 0, tIndex = 0;
        int sLength = s.length(), tLength = t.length();

        // Traverse both strings
        while (sIndex < sLength && tIndex < tLength) {
            // If characters match, move the t pointer forward
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            // Always move the s pointer forward
            sIndex++;
        }

        // The remaining characters in t are the ones we need to append
        return tLength - tIndex;
    }
}