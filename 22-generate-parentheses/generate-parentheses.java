class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen_Par(n,0,0,"",result);
        return result;
    }
    public static void gen_Par(int n, int opencount, int closecount, String current,List<String> result){
        if(current.length() == 2*n){
            result.add(current);
            return;
        }

        if(opencount < n){
            gen_Par(n,opencount + 1,closecount, current + "(", result );
        }

        if(closecount < opencount){
            gen_Par(n,opencount, closecount + 1, current + ")", result);
        }
    }
}