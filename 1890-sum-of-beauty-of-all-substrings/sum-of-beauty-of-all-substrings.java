class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        // We will traverse the each substring then at each step we will calculate themin and max frequency and find the total beauty
        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            int max = 0;

            for(int j =i; j < n; j++){
                int index = s.charAt(j) - 'a';
                freq[index]++;
                max = Math.max(max, freq[index]);

                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++){
                    if(freq[k] > 0){
                        min = Math.min(min, freq[k]);
                    }
                }

                totalBeauty += max - min;
            }
        }

        return totalBeauty;
    }
}