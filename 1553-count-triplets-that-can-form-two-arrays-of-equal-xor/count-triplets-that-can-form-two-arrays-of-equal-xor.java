class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Prefix XOR array
        int[] prefixXor = new int[n + 1];
        prefixXor[0] = 0;

        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }

        // Iterate through all possible pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                // If the XOR from i to j-1 equals the XOR from j to k
                if (prefixXor[i] == prefixXor[k + 1]) {
                    count += k - i;
                }
            }
        }

        return count;
    }
}