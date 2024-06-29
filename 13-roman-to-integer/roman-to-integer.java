class Solution {
    public int romanToInt(String s) {
        // First we will map the Symbol to value in map
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Let initialize value = 0
        int value = 0;

        // We will traverse the string
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                value -= map.get(s.charAt(i));
            }else{
                value += map.get(s.charAt(i));
            }
        }

        return value;
    }
}