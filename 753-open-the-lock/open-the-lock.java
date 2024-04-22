class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
        
        Set<String> deadendsSet = new HashSet<>();
        for (String deadend : deadends)
            deadendsSet.add(deadend);
        
        if (deadendsSet.contains("0000"))
            return -1;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        
        int turns = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] currentArray = current.toCharArray();
                        char newChar = (char) (((currentArray[j] - '0') + k + 10) % 10 + '0');
                        currentArray[j] = newChar;
                        String newWheel = new String(currentArray);
                        
                        if (newWheel.equals(target))
                            return turns + 1;
                        
                        if (!deadendsSet.contains(newWheel) && !visited.contains(newWheel)) {
                            visited.add(newWheel);
                            queue.offer(newWheel);
                        }
                    }
                }
            }
            turns++;
        }
        
        return -1;
    }
}