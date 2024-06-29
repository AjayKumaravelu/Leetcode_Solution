class Solution {
    public String intToRoman(int num) {
        String ans = "";
        // We will add the relevant 900 etc from other symbol
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // We will traverse the num by position
        for(int pos = 0; pos < value.length; pos++){
            while(num >= value[pos]){
                ans += symbol[pos];
                num -= value[pos];
            }
        }

        return ans;
    }
}