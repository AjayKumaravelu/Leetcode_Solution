class Solution {
    public int[] findArray(int[] pref) { 
        // We are finding the prefix array length
        int n = pref.length;
        // We are looping from the last element to 2nd element
        for(int i = n-1; i >= 1 ; --i){
            // Finding the xor with previous element
            pref[i] ^= pref[i-1];
        }
        return pref;
        
    }
}