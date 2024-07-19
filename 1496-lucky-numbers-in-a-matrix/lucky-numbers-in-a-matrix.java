class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            // Find the minimum element in the current row
            int minVal = matrix[i][0];
            int minIdx = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minIdx = j;
                }
            }
            
            // Check if the found minimum element is the maximum in its column
            boolean isLucky = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][minIdx] > minVal) {
                    isLucky = false;
                    break;
                }
            }
            
            if (isLucky) {
                result.add(minVal);
            }
        }
        
        return result;
    }
}