class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m][n];

        Map<Character, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            pos.putIfAbsent(c, new ArrayList<>());
            pos.get(c).add(i);
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2); // Initialize with infinity
        }

        for (int i : pos.get(key.charAt(0))) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j : pos.get(key.charAt(i))) {
                for (int k : pos.get(key.charAt(i - 1))) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i : pos.get(key.charAt(m - 1))) {
            minSteps = Math.min(minSteps, dp[m - 1][i]);
        }

        return minSteps;
    }
}