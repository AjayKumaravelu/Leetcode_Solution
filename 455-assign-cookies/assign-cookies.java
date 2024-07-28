class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0, right = 0;

        // Left point on s and right point on g
        while(left < m && right < n){
            if(g[right] <= s[left]) right = right + 1;
            left = left + 1;
        }

        return right;
    }
}