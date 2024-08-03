class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);

        String commonPrefix = "";
        String first = strs[0];
        String last = strs[n - 1];

        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) == last.charAt(i) && i < last.length()){
                commonPrefix += first.charAt(i);
            }else{
                break;
            }
        }

        return commonPrefix;
    }
}