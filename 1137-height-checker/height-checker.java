class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] arr = heights.clone();
        for(int i = 0; i < n - 1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++ ){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(heights[i] != arr[i]){
                count++; 
            }
        }
        return count;
    }
}