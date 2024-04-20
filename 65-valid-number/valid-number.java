class Solution {
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