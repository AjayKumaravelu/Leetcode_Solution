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
        // ArrayList<Integer> temp = new ArrayList<>();
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] != 0){
        //         temp.add(nums[i]);
        //     }
        // }

        // int n = temp.size();

        // for(int i = 0; i < n; i++){
        //     nums[i] = temp.get(i);
        // }

        // for(int i = n; i < nums.length; i++){
        //     nums[i] = 0;
        // }

        // Optimal
        // Basically using two pointers i and j
        // Where j  will point 0 and i will point non zero we will swap them so that non zero are in first followed by zero

        int j = -1;

        // First we will find the j with first 0
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }

        int count = 0;
        // Then we will traverse the i with 
        for(int i = 0; i < nums.length; i++){
            if(i > j && nums.length >= 2){
                if(nums[i] != 0 && j != -1){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                    count++;
                }
            }else{
                if(nums.length >= 2){
                    if(i > j){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }else{
                        //nums[i] = 0
                    }
                }
            }
        }

        // while(count < nums.length && nums.length > 2){
        //     nums[count] = 0;
        //     count++;
        // }
    }
}