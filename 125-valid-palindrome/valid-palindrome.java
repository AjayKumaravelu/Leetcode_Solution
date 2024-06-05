class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        StringBuilder filteredString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredString.append(Character.toLowerCase(c));
            }
        }
        String r = filteredString.toString();

        if (r.isEmpty()) {
            return true;
        }
        
        return Pallindrome(i,r);
    }
    public boolean Pallindrome(int i, String s){
        if(i > s.length()/2){
            return true;
        }
        if(s.charAt(i) != s.charAt(s.length() - i - 1)){
            return false;
        }
        return Pallindrome(i+1, s);
    }
}