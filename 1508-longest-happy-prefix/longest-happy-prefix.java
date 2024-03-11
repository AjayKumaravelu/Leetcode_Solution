class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int j = 0;

        for(int i = 1; i < n;){
            if(s.charAt(i) == s.charAt(j)){
                lps[i++] = ++j;
            }
            else{
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    lps[i++] = 0;
                }
            }
        }
        int happyPrefixLength = lps[n-1];
        return happyPrefixLength > 0 ? s.substring(0,happyPrefixLength) : "";
        
    }
}