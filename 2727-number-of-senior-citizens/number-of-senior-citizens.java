class Solution {
    public int countSeniors(String[] details) {
        int seniorCount = 0;
        for (String detail : details) {
            // Extract the age substring and convert it to an integer
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                seniorCount++;
            }
        }
        return seniorCount;
    }
}