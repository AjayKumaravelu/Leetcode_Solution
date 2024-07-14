class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentMap = new HashMap<>();
        int i = 0;
        int length = formula.length();
        
        while (i < length) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                // Push the current map to the stack and start a new one
                stack.push(currentMap);
                currentMap = new HashMap<>();
                i++;
            } else if (ch == ')') {
                // Find the multiplier
                i++;
                int start = i;
                while (i < length && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                
                // Pop the previous map and merge with current one
                Map<String, Integer> tempMap = currentMap;
                currentMap = stack.pop();
                for (String key : tempMap.keySet()) {
                    currentMap.put(key, currentMap.getOrDefault(key, 0) + tempMap.get(key) * multiplier);
                }
            } else {
                // Parse the element name
                int start = i;
                i++;
                while (i < length && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(start, i);
                
                // Parse the count
                start = i;
                while (i < length && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                
                // Update the current map
                currentMap.put(element, currentMap.getOrDefault(element, 0) + count);
            }
        }
        
        // Generate the final result string
        StringBuilder result = new StringBuilder();
        List<String> elements = new ArrayList<>(currentMap.keySet());
        Collections.sort(elements);
        for (String element : elements) {
            result.append(element);
            int count = currentMap.get(element);
            if (count > 1) {
                result.append(count);
            }
        }
        
        return result.toString();
    }
}