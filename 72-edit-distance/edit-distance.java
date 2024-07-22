class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // We will use tabulation method -- we will use zero based indexing
        int[][] dp = new int[n+1][m+1];
        // Base condition
        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dp[0][j] = j;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                // for insert dp[i][j-1], for delete dp[i-1][j], for replace dp[i-1][j-1]
                else dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }

        return dp[n][m];
    }



    // static int[][] dp;
    // public int minDistance(String word1, String word2) {
    //     dp = new int[word1.length() + 1][word2.length() + 1];
    //     for(int[] d : dp){
    //         Arrays.fill(d,-1);
    //     }
    //     return rec(word1, word2, word1.length(), word2.length());
    // }

    // public int rec(String s, String t, int x, int y){
    //     if (x == 0){
    //         return y;
    //     }
    //     if (y == 0){
    //         return x;
    //     }
    //     if(dp[x][y] != -1){
    //         return dp[x][y];
    //     }
    //     if(s.charAt(x-1) == t.charAt(y-1)){
    //         dp[x][y] = rec(s,t,x-1,y-1);

    //     }
    //     else{
    //         dp[x][y] = Math.min(1 + rec(s,t,x,y-1), Math.min(1 + rec(s,t,x-1,y) , 1 + rec(s,t,x-1,y-1)));
    //     }
    //     return dp[x][y];
    // }
}