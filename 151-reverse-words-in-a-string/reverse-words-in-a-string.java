class Solution {
    public String reverseWords(String s) {
        String[] result = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for(int i = result.length - 1; i > 0 ; i--){
            reversed.append(result[i]).append(" ");
        } 
        if(result.length > 0){
            reversed.append(result[0]);
        }
        return reversed.toString();
    }
}