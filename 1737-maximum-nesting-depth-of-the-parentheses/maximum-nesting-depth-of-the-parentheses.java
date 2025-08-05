class Solution {
    public int maxDepth(String s) {
        int currMax = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                currMax++;
                if(currMax > max){
                    max = currMax;
                }
            }else if(ch == ')'){
                currMax--;
                if(currMax < 0){
                    return -1;
                }
            }
        }

        // Unbalanced String
        if(currMax != 0){
            return -1;
        }

        return max;
    }
}