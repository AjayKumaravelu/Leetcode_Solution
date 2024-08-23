class Solution {
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper function to add two fractions
    private static int[] addFractions(int num1, int den1, int num2, int den2) {
        int numerator = num1 * den2 + num2 * den1;
        int denominator = den1 * den2;
        int gcd = gcd(Math.abs(numerator), denominator);
        return new int[]{numerator / gcd, denominator / gcd};
    }

    public static String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        
        int i = 0;
        while (i < expression.length()) {
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }
            
            int num = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            i++; // skip the '/'
            
            int den = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                den = den * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            int[] result = addFractions(numerator, denominator, sign * num, den);
            numerator = result[0];
            denominator = result[1];
        }
        
        return numerator + "/" + denominator;
    }
}