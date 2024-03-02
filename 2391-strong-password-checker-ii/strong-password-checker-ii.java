class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if(n < 8){
            return false;
        }
        int lword = 0;
        int digit = 0;
        int Uword = 0;
        int Spe_char = 0;
        for(int i = 0; i <= n - 1 ; i++){
            if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                Uword++;
            }
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                lword++;
            }
            if("!@#$%^&*()-+".indexOf(password.charAt(i)) != -1 ){
                Spe_char++;
            }
            if(password.charAt(i) >= '0' && password.charAt(i) <= '9'){
                digit++;
            }
            if(i < n -1 && password.charAt(i) == password.charAt(i + 1)){
                return false;
            }
        }
        if(n >= 8 && lword > 0 && digit > 0 && Uword > 0 && Spe_char > 0){
            return true;
        }
        return false;  
    }
}