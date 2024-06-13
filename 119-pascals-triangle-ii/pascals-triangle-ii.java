class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int i = 1; i < rowIndex + 1; i++){
            ans = ans * (rowIndex - i + 1);
            ans = ans / i;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
}