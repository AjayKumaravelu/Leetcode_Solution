// class Solution {
//     public void moveZeroes(int[] nums) {
//         int n = nums.length;  
//         int nonZero = 0;   
//         for(int i = 0; i < n  ; i++){
//             if (nums[i] != 0){
//                 nums[nonZero++] =nums[i];
//             }
//         }
//         while(nonZero < n){
//             nums[nonZero++] = 0;
//         }
        
//     }
// }


class Solution {
    public void moveZeroes(int[] nums){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                temp.add(nums[i]);
            }
        }

        int n = temp.size();

        for(int i = 0; i < n; i++){
            nums[i] = temp.get(i);
        }

        for(int i = n; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}