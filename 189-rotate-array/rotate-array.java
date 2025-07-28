// class Solution {
//     public void rotate(int[] nums, int k) {
//         int[] result = new int[nums.length];
//         int n = nums.length;
//         k = k % n;
//         for (int i = 0 ; i < k ; i++){
//             result[i] = nums[n - k + i];
//         }
 
//         for(int i = 0; i < n - k ; i++){
//             result[k + i] = nums[i];
//         }
        
//         for(int i = 0; i < n; i++){
//             nums[i] = result[i];
//         }

//         for(int i = 0; i < nums.length ; i++){
//             System.out.print(nums[i] + " ");
//         }
//     }
// }

class Solution {
    public void rotate(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n];
        
        k = k % n;
        int j = 0;
        for(int i = n - k; i < n; i++){
            res[j] = nums[i];
            j++;
        }

        for(int i = 0; i < n - k; i++){
            res[j] = nums[i];
            j++;
        }

        for(int i = 0; i < n; i++){
            nums[i] = res[i];
        }

        for(int i = 0; i < n ; i++){
            System.out.print(nums[i] + " ");
        }
    }
}