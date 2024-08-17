class Solution {
    public double myPow(double x, int n) {
        // to avoid overflowing
        double ans = 1.0;
        // To assign duplicate variable for n
        long nn = n;
        // if n is negative we are making it as positive
        if(nn < 0){
            nn = -1 * nn;
        }
        while(nn > 0){
            // if the power is odd
            if(nn % 2 == 1){
                ans = ans * x;
                nn = nn - 1;
            }
            else{
                x = x * x;
                nn = nn/2;
            }
        }
        // if n is neagtive
        if(n < 0){
            ans = (double)1.0/(double)ans;
        }
        return ans;
    }

}