class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0){
            return false;
        }

        if(x == reverseNum(x)){
            return true;
        }else{
            return false;
        }
    }

    public int reverseNum(int x){
        x = Math.abs(x);

        int rev = 0;

        while(x > 0){
            int rem = x % 10;
            rev = rev * 10 + rem;
            x = x/10;
        }

        return rev;
    }
}