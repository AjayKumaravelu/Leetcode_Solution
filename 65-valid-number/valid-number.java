class Solution {
    /*public boolean isNumber(String s) {
        if(s == null || s.length() == 0) 
            return false;
        int start = 0;
        // handle the space at the front
        while(start < s.length() && s.charAt(start) == ' ')
            start++;
        if(start == s.length())
            return false;
        if(s.charAt(start) == '+' || s.charAt(start) == '-')
            start++;
        boolean hasExp = false;
        boolean hasNum = false;
        boolean hasDot = false;
        while(start < s.length()) {
            char c = s.charAt(start);
            // handle the space in the end
            if(c == ' ') {
                while(start < s.length() && s.charAt(start) == ' ')
                    start++;
                if(start == s.length())
                    break;
                return false;
            } else if (c >= '0' && c <= '9') {
                hasNum = true;
            } else if(c == '+' || c == '-') {
                if(s.charAt(start - 1) != 'e')
                    return false;
            } else if(c == 'e') {
                if(hasExp || !hasNum) 
                    return false;
                hasExp = true;
                hasNum = false;
            } else if(c == '.') {
                if(hasExp || hasDot) 
                    return false;
                hasDot = true;
            } else
                return false;
            start++;
        }
        return hasNum;
    }*/
    
    public static boolean isNumber(String s){
        s = s.trim();
        if (s.length() == 0) return false;
        int k = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-'){
            k++;
        }
        boolean num = false, dot = false, exp = false;
        while (k < s.length()){
            char ch = s.charAt(k);
            if (ch >= '0' && ch <= '9'){
                num = true;
            } else if(ch == '.'){
            if (exp || dot) return false;
                dot = true;
            }else if (ch == 'e' || ch == 'E'){
                if (exp || !num) return false;
                    exp = true;
                    num = false;
                }else if (ch == '+' || ch == '-'){
                    if (s.charAt(k-1) != 'e' && s.charAt(k-1)!= 'E'){
                        return false;
                    }
                }else{
                    return false;
                }
            k++;
        }
        return num;
    }
    
}