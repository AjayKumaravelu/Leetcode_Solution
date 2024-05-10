class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
    double left = 0D, right = 1D;
    while (left < right) {
        double mid = left + (right - left) / 2;
        double max_f = 0D;
        int total = 0;
        int p = 0, q = 0;
        for (int i = 0, j = 1; i < n - 1; i++) {
            while (j < n && arr[i] > mid * arr[j]) ++j;
            if (n == j) break;
            total += (n - j);
            double cur = arr[i] * 1D / arr[j];
            if (cur > max_f) {
                p = i;
                q = j;
                max_f = cur;
            }
        }
        if (total == k) return new int[]{arr[p], arr[q]};
        else if (total > k) right = mid;
        else left = mid;
    }
    return new int[]{};
    }
}