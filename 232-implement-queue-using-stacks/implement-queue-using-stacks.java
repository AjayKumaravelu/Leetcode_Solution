class MyQueue {
    // We are declaring two stacks
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();   
    }
    
    public void push(int x) {
        // We will push the element into the input stack
        input.push(x);
    }
    
    public int pop() {
        // Transfer elements from input to output if output is empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        // Transfer elements from input to output if output is empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        // Queue is empty only if both input and output stacks are empty
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */