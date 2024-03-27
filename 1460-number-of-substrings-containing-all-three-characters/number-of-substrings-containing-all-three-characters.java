class Solution {
    public int numberOfSubstrings(String s) {
        // Array to keep track of the last seen index of a, b and c
        int[] lastseen = {-1,-1,-1};

        int count = 0;

        // Loop through each character of the string
        for(int i = 0; i <s.length(); i++){
            // Update the last seen index of the character at position 'i'
            lastseen[s.charAt(i) - 'a'] = i;
            // Check if all characters 'a', 'b', and 'c' have been seen at least once
            if(lastseen[0] != -1 && lastseen[0] != -1 && lastseen[0] != -1){
                // Find the minimum last seen index among characters 'a', 'b', and 'c'
                count += (1 + Math.min(lastseen[0], Math.min(lastseen[1],lastseen[2])));
            }
        }
        return count;
    }
}