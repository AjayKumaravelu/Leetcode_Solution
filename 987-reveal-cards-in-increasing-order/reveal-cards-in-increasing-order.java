class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Deque<Integer> indexOrder = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            indexOrder.offer(i);
        }

        int[] result = new int[n];
        for (int card : deck) {
            result[indexOrder.poll()] = card;
            if (!indexOrder.isEmpty()) {
                indexOrder.offer(indexOrder.poll());
            }
        }

        return result;
    }
}