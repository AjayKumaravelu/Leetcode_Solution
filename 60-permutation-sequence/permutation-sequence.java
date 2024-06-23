class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ans = new ArrayList<>();

        // We are finding the factorial
        int factorial = 1;
        for(int i = 1; i < n; i++){
            factorial = factorial * i;
            ans.add(i);
        }
        ans.add(n);

        String res = "";
        // As we are going throught 0th index we are reducing it by 1
        k = k - 1;

        // We are now finding out the index by / operation and we are updating it by % operation
        while(true){
            res = res + ans.get(k / factorial);
            ans.remove(k / factorial);
            if(ans.size() == 0){
                break;
            }
            k = k % factorial;
            factorial = factorial / ans.size();
        }

        return res;
    }
}