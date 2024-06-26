class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,ans,path);
        return ans;
    }

    public void func(int index, String s, List<List<String>> ans, List<String> path){
        if(index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPallindrome(s,index,i)){
                //we will add substring
                path.add(s.substring(index, i+1));
                //We will call the recursive function
                func(i + 1, s, ans, path);
                //We will remove the last element as we backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPallindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}