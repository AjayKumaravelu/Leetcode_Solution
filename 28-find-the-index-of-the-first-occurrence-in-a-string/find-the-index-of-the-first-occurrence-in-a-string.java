class Solution {
    // private final int PRIME = 101;

    // private double CalculateHash(String str){
    //     double hash = 0;

    //     // I will traverse the string and hash the string
    //     for(int i = 0; i < str.length(); i++){
    //         hash = hash + str.charAt(i) * Math.pow(PRIME,i);
    //     }

    //     return hash;
    // }

    // private double updateHash(double prevHash, char oldIndexchar, char newIndexchar, int patternLength){
    //     // Firstly we will remove the last index
    //     double newHash = (prevHash - oldIndexchar)/PRIME;
    //     newHash = newHash + newIndexchar * Math.pow(PRIME,patternLength - 1);
    //     return newHash;
    // }

    // public int Search(String text, String pattern){
        
    //     int n = pattern.length();
    //     //check whether the pattern is greater than text
    //     if(text.length() < n) return -1;
    //     double textHash = CalculateHash(text.substring(0, n));
    //     double patternHash = CalculateHash(pattern);
        

    //     for(int i = 0; i <= text.length() - n; i++){
    //         if(textHash == patternHash){
    //             if(text.substring(i, i + n).equals(pattern)){
    //                 return i;
    //             }
    //         }

    //         if(i < text.length() - n){
    //             textHash = updateHash(textHash, text.charAt(i), text.charAt(i + n), n);
    //         }
    //     }
    //     return -1;
    // }
    // // public int strStr(String haystack, String needle) {
    // //     // Using Rabin Karp Algorithm
    // //     return Search(haystack, needle);
    // // }

    // public int strStr(String haystack, String needle) {
    //     if (haystack.length() < needle.length()) {
    //         return -1;
    //     }
        
    //     for (int i = 0; i <= haystack.length() - needle.length(); i++) {
    //         if (haystack.substring(i, i + needle.length()).equals(needle)) {
    //             return i;
    //         }
    //     }
        
    //     return -1;        
    // }
    
    public static void computeLPS(String pat, int M, int[] lps){
        // Initially len and the lps[0] = 0
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while(i < M){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1]; 
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public int strStr(String haystack, String needle){
        int n = haystack.length();
        int m = needle.length();

        // Handle the case when needle is empty
        if (m == 0) {
            return 0;
        }

        // Handle the case when needle is longer than haystack
        if (m > n) {
            return -1;
        }

        int[] lps = new int[m];

        computeLPS(needle, m, lps);

        int i = 0;
        int j = 0;

        while((n - i) >= (m - j)){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }

            // When the j reaches the m return the j
            if(j == m){
                return i - j;
            }

            else if(i < n && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i = i + 1;
                }
            }
        }
        return -1;

    }
}