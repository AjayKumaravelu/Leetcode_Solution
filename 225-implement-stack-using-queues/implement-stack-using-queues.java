class MyStack {
    // We are using 2 Queues
    Queue<Integer> q1;


    public MyStack() {
        // Creating Linked List with each queue
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        // We use single queue to implement  it
        // Step 1 we will push the element and move the top above the push element until size - 1
        q1.add(x);
        // We will traverse 
        for(int i = 0; i < q1.size() - 1; i++){
            //first i will push the top element above
            q1.add(q1.peek());
            // Then we will pop the top element
            q1.remove();
        }
        
    }
    
    public int pop() {
        return q1.remove(); 
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();     
    }

    public int size() {
        return q1.size();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */