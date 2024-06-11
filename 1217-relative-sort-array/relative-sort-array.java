class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            orderMap.put(arr2[i], i);
        }

        // Sort arr1 using a custom comparator
        Integer[] arr1Wrapper = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1Wrapper, (a, b) -> {
            if (orderMap.containsKey(a) && orderMap.containsKey(b)) {
                return orderMap.get(a) - orderMap.get(b);
            } else if (orderMap.containsKey(a)) {
                return -1;
            } else if (orderMap.containsKey(b)) {
                return 1;
            } else {
                return a - b;
            }
        });

        // Convert Integer[] back to int[]
        return Arrays.stream(arr1Wrapper).mapToInt(Integer::intValue).toArray();
    }
}