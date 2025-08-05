 class Solution {
    // public String longestPalindrome(String s) {
    //     int count = -1;
    //     String ans = "";
    //     int n = s.length();
    //     boolean[][] dp = new boolean[n][n];
    //     for (int g = 0; g < n; g++) {
    //         for (int i = 0, j = g; j < n; i++, j++) {
    //             if (g == 0) {
    //                 dp[i][j] = true;
    //             } else if (g == 1) {
                    
    //                 dp[i][j] = (s.charAt(i) == s.charAt(j));
    //             } else {
    //                 dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
    //             }
    //             if (dp[i][j] && count < s.substring(i, j + 1).length()) {
    //                 ans = s.substring(i, j + 1);
    //                 count = ans.length();
    //             }
    //         }
    //     }
    //     return ans;
    // }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public String longestPalindrome(String s){
        int max = 1;
        int n = s.length();
        int start = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalindrome(s.substring(i,j + 1)) && j - i + 1 > max){
                    start = i;
                    max = j - i + 1;
                }
            }
        }

        return s.substring(start,start + max);
    }
}