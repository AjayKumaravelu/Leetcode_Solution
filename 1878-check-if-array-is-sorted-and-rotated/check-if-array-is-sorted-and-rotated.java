// class Solution {
//     public boolean check1(int[] nums) {
//         // int count_drop = 0;
//         // for(int i = 0; i < nums.length; i++){
//         //     if(nums[(i + 1) % nums.length] >= nums[i]){
                 
//         //     }
//         //     else{
//         //         count_drop++;
//         //     }
//         // }
//         // if(count_drop <= 1)return true;
//         // else return false;  

//         int dropCount = 0;
//         int n = nums.length;

//         // Traverse the array to count the number of drops
//         for (int i = 0; i < n; i++) {
//             if (nums[i] > nums[(i + 1) % n]) {
//                 dropCount++;
//             }
//         }

//         // If the drop count is more than 1, the array is not sorted and rotated
//         // If the drop count is 0 or 1, the array is sorted and rotated
//         return dropCount <= 1;
//     } 


//     public boolean check(int[] nums){
//         int drop = 0;
//         int n = nums.length;

//         for(int i = 0; i < n; i++){
//             if(nums[i] > nums[(i + 1) % n]){
//                 drop++;
//             }
//         }

//         return drop <= 1;
//     }   
// }


class Solution{
    public boolean check(int[] nums){
        int dropCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[(i+1) % nums.length]){
                dropCount++;
            }
        }

        return dropCount <= 1;
    }
}