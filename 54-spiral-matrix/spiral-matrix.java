class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // counting no of rows
        int n = matrix.length;
        // counting no of columns
        int m = matrix[0].length;

        List<Integer> ans = new ArrayList<Integer>();

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m -1;

        // We are keeping track of top and bottom && left and right to check the exit condition
        while( top <= bottom && left <= right){

            // We are traversing from left to right
            for(int i = left ; i <= right ; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            
            // We are traversing from top to bottom
            for(int i = top ; i <= bottom ; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if( top <= bottom){

                // We are traversing from right to left
                for(int i = right ; i >= left ; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;

            }

            if( left <= right){

            //We are traversing from bottom to top
            for(int i = bottom; i >= top ; i--){
                ans.add(matrix[i][left]);
            }
            left++;

            }

        }
        return ans;
    }
}