import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // If the lengths of the strings are different, they can't be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if there is a mapping for charS in mapS
            if (mapS.containsKey(charS)) {
                // If the mapped character does not match the corresponding character in t, return false
                if (mapS.get(charS) != charT) {
                    return false;
                }
            } else {
                // If charT is already mapped to some other character, return false
                if (mapT.containsKey(charT)) {
                    return false;
                }
                // Create the mapping between charS and charT
                mapS.put(charS, charT);
                mapT.put(charT, charS);
            }
        }

        return true;
    }
}
