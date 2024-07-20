class Solution {
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length();
    //     int n = text2.length();
    //     int[][] LCS = new int[m+1][n+1];
    //     for(int i = 0; i <= m ; i++){
    //         for(int j = 0; j <= n ; j++){
    //             if( i == 0 || j == 0){
    //                 LCS[i][j] = 0;
    //             }
    //             else if (text1.charAt(i-1) == text2.charAt(j-1)){
    //                 LCS[i][j] = 1 + LCS[i-1][j-1];
    //             }
    //             else{
    //                 LCS[i][j] = Math.max(LCS[i-1][j] , LCS[i][j-1]);
    //             }
    //         }
    //     }
    //     return LCS[m][n];
    // }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        // Initialise
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}