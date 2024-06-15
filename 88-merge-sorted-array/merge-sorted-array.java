class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = n + m - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

        while(j >= 0){
            nums1[k--] = nums2[j--];
        }



        // int left = m - 1;
        // int right = 0;
        // if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
        //     return;
        // }
        // // We Know that 1st array last element is greater and the 1st element in the 2nd array is smaller in that array
        // while(left >= 0 && right < n){
        //     if(nums1[left] > nums2[right]){
        //         int temp = nums1[left];
        //         nums1[left] = nums2[right];
        //         nums2[right] = temp;
        //         left--;
        //         right++;
        //     }else{
        //         break;
        //     }
             
        // }
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
    }

}