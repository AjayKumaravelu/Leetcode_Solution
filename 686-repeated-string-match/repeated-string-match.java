class Solution {
    private final int PRIME = 101;

    private double CalculateHash(String str){
        double hash = 0;

        // I will traverse the string and hash the string
        for(int i = 0; i < str.length(); i++){
            hash = hash + str.charAt(i) * Math.pow(PRIME,i);
        }

        return hash;
    }

    private double updateHash(double prevHash, char oldIndexchar, char newIndexchar, int patternLength){
        // Firstly we will remove the last index
        double newHash = (prevHash - oldIndexchar)/PRIME;
        newHash = newHash + newIndexchar * Math.pow(PRIME,patternLength - 1);
        return newHash;
    }

    public int Search(String text, String pattern){
        int n = pattern.length();
        double textHash = CalculateHash(text.substring(0, n));
        double patternHash = CalculateHash(pattern);

        for(int i = 0; i <= text.length() - n; i++){
            if(textHash == patternHash){
                if(text.substring(i, i + n).equals(pattern)){
                    return 1;
                }
            }

            if(i < text.length() - n){
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + n), n);
            }
        }
        return 0;
    }
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;
        int count = 1;

        String source = a;
        while(source.length() < b.length()){
            source += a;
            count++;
        }

        if(source == b) return count;
        if(Search(source, b) == 1) return count;
        if(Search(source + a, b) == 1) return count + 1;

        return -1;
        
    }
}