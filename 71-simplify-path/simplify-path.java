class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");

        for(String component : components){
            if(component.equals("") || component.equals(".")){
                continue;
            }
            else if(component.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop(); // If stack is not empty, pop to go up one directory level
                }
            }
            else {
                stack.push(component); // Push valid directory names onto the stack
            }
        }
        
        // Construct the simplified path
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.insert(0, "/" + stack.pop()); // Insert directories from stack into the result
        }
        
        // If result is empty, return the root directory
        return result.length() == 0 ? "/" : result.toString();
    }
}
