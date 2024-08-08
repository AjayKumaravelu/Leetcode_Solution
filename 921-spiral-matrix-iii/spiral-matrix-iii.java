class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;

        // Directions: right, down, left, up
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int step = 0;
        result[index++] = new int[]{rStart, cStart};
        
        while (index < rows * cols) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    step++;
                }
                for (int j = 0; j < step; j++) {
                    rStart += dr[i];
                    cStart += dc[i];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = new int[]{rStart, cStart};
                    }
                }
            }
        }

        return result;
    }
}