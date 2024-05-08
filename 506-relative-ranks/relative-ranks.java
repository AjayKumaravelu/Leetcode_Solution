class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] sortedScore = Arrays.copyOf(score, score.length);
        Arrays.sort(sortedScore);
        HashMap<Integer, String> rankMap = new HashMap<>();

        for (int i = 0; i < sortedScore.length; i++) {
            int rank = sortedScore.length - i;
            if (rank == 1) {
                rankMap.put(sortedScore[i], "Gold Medal");
            } else if (rank == 2) {
                rankMap.put(sortedScore[i], "Silver Medal");
            } else if (rank == 3) {
                rankMap.put(sortedScore[i], "Bronze Medal");
            } else {
                rankMap.put(sortedScore[i], String.valueOf(rank));
            }
        }

        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = rankMap.get(score[i]);
        }

        return result;
    }
}