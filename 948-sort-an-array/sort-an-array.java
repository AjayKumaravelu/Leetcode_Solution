class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the two halves
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            // Merge the sorted halves
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = nums[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        // Merge the temp arrays back into nums[left..right]
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray if any
        while (i < n1) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray if any
        while (j < n2) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }
}