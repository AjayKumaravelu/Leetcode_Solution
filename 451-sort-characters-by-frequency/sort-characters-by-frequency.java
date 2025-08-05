class Solution {
    public String frequencySort(String s) {
        // Step 1: Counting frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int value = map.getOrDefault(ch,0);
            map.put(ch, value+1);
        }    

        // Step 3: Using priority Queue (Max Heap) we are sorting
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(map.entrySet());


        String res = "";
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> temp = pq.poll();
            char ch = temp.getKey();
            int freq = temp.getValue();

            for(int i = 0; i < freq; i++){
                res += ch;
            }
        }

        return res;
    }
}