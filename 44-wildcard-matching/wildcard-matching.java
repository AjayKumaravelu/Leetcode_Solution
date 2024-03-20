class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] T = new boolean[n+1][m+1];
        T[0][0] = true;
        for(int j = 1 ; j <= m ; j++){
            if(p.charAt(j-1) == '*'){
                T[0][j] = T[0][j-1];
            }
        }

        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                if(p.charAt(j-1) == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
                else if(p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)){
                    T[i][j] = T[i-1][j-1];
                }
            }
        }
        return T[n][m];
         
    }
}