class Solution {
    public int singleNumber1(int[] nums) {
        // Using XOR method for optimal 
        int n = nums.length;

        int XOR = 0;
        for(int i = 0; i < nums.length; i++){
            XOR = XOR ^ nums[i];
        }
        return XOR;
    }

    public int singleNumber(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value+1);
        }

        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            if(it.getValue() == 1){
                return it.getKey();
            }
        }

        return -1;


    }

    // public int singleNumber(int[] nums){
    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     for(int i = 0; i < nums.length; i++){
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //     }

    //     for(Map.Entry<Integer, Integer> it: map.entrySet()){
    //         if(it.getValue() == 1){
    //             return it.getKey();
    //         }
    //     }
    //     return -1;
    // }
}