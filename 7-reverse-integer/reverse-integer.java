class Solution {
    public int reverse(int x) {
        int rev = 0;
        int sign = -1;

        if(x < 0){
            x = Math.abs(x);   
        }else{
            sign = 1;
        }

        while(x > 0){
            int rem = x % 10;

            // Check for overflow
            if (rev > (Integer.MAX_VALUE - rem) / 10) {
                return 0;
            }

            rev = (rev * 10) + rem;
            x = x/10;
        }
        
        return sign * rev;
    }
}