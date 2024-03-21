class Solution {
    static int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return rec(word1, word2, word1.length(), word2.length());
    }

    public int rec(String s, String t, int x, int y){
        if (x == 0){
            return y;
        }
        if (y == 0){
            return x;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        if(s.charAt(x-1) == t.charAt(y-1)){
            dp[x][y] = rec(s,t,x-1,y-1);

        }
        else{
            dp[x][y] = Math.min(1 + rec(s,t,x,y-1), Math.min(1 + rec(s,t,x-1,y) , 1 + rec(s,t,x-1,y-1)));
        }
        return dp[x][y];
    }
}