class Solution {
    static String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        possibleWords(digits, "", result);
        return result;
    }

    public static void possibleWords(String digits, String current, List<String> result) {
        if (digits.length() == 0) {
            result.add(current);
            return;
        }
        String key = keypad[digits.charAt(0) - '0'];
        for (int i = 0; i < key.length(); i++) {
            possibleWords(digits.substring(1), current + key.charAt(i), result);
        }
    }
}
