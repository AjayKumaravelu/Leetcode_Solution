class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Step 1: Transpose the array 
        // As the diagonal remain same, the upper half element is swapped with lower half element
        for(int i = 0; i < n ; i++){
            for(int j = i + 1; j < m; j++){
                swap(matrix,i,j);
            }
        }

        // Step 2: Reverse the row in the array
        for(int i = 0; i < n; i++){
            reverse(matrix[i]);
        }
    }

    public void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public void reverse(int[] row){
        int left = 0;
        int right = row.length - 1;
        while(left < right){
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

}