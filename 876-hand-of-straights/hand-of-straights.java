class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Count the frequency of each card
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // Sort the keys (unique card values)
        List<Integer> sortedKeys = new ArrayList<>(countMap.keySet());
        Collections.sort(sortedKeys);

        // Try to form groups
        for (int key : sortedKeys) {
            if (countMap.get(key) > 0) {
                int numGroups = countMap.get(key);
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = key + i;
                    if (countMap.getOrDefault(currentCard, 0) < numGroups) {
                        return false;
                    }
                    countMap.put(currentCard, countMap.get(currentCard) - numGroups);
                }
            }
        }

        return true;
    }
}