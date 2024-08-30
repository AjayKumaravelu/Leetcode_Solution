class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0; // Keeps track of the number of open parentheses

        for (char c : s.toCharArray()) {
            // If we encounter an opening parenthesis
            if (c == '(') {
                // Only add to result if it's not an outer parenthesis
                if (openCount > 0) {
                    result.append(c);
                }
                openCount++; // Increment open parenthesis count
            } else if (c == ')') {
                openCount--; // Decrement open parenthesis count
                // Only add to result if it's not an outer parenthesis
                if (openCount > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}