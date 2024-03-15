class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        generatePermutation(nums,left,right,result);
        return result;
    }

    public static void generatePermutation(int[] nums,int left ,int right,List<List<Integer>> result){
        if(left == right){
            printArray(nums,result);
        }
        else{
            for(int i = left ; i <= right ; i++){
                swap(nums,left,i);
                generatePermutation(nums,left+1,right,result);
                swap(nums,left,i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(int[] nums,List<List<Integer>> result){
        List<Integer> permutation = new ArrayList<>();
        for(int num: nums){
            permutation.add(num);
        }
        result.add(permutation);
    }
}

 

/*class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutation(nums, 0, result);
        return result;
    }

    public static void generatePermutation(int[] nums, int index, List<List<Integer>> result){
        if(index == nums.length - 1){
            addToList(nums, result);
        }
        else{
            for(int i = index; i < nums.length; i++){
                swap(nums, index, i);
                generatePermutation(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void addToList(int[] nums, List<List<Integer>> result){
        List<Integer> permutation = new ArrayList<>();
        for(int num: nums){
            permutation.add(num);
        }
        result.add(permutation);
    }
}*/
