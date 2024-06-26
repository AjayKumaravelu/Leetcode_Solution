class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        // we will traverse the input
        for(char it: s.toCharArray()){
            // if it is open bracket then we will push
            if(it == '(' || it == '[' || it == '{'){
                st.push(it);
            }
            else{
                // we will check whether stack is empty if empty then there no corresponding open bracket for current clsoe bracket
                if(st.isEmpty()) return false;
                else{
                    // we will pop the lastelement and check whether it is opposite to the currentelement
                    char c = st.pop();

                    // we will check whether they are opposite to each other
                    if((c == '(' && it == ')') || (c == '[' && it == ']') || (c == '{' && it == '}')){
                        continue;
                    }else{
                        return false;
                    }
                }
            } 
        }
        return st.isEmpty();
    }
}