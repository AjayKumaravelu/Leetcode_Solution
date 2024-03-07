class MyStack {
    // We are using 2 Queues
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        // Creating Linked List with each queue
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();   
    }
    
    public void push(int x) {
        // Push the element into a non empty Queue
        if(!q1.isEmpty()){
            q1.offer(x);
        }
        else{
            q2.offer(x);
        }
        
    }
    
    public int pop() {
        // Move elements from non empty queue to empty queue, except the last one
        if(q1.isEmpty() && q2.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        if(!q1.isEmpty()){
            while(q1.size() > 1){
                q2.offer(q1.poll());
            }
            return q1.poll();
        }

        else{
            while(q2.size() > 1){
                q1.offer(q2.poll());
            }
            return q2.poll();
        }   
    }
    
    public int top() {
        // Poping the top most element
        int top = pop();
        // Pushing the top element back after retrieving it
        push(top);
        return top;
        
    }
    
    public boolean empty() {
        // Checking both q1 and q2 whether it is empty or not
        return q1.isEmpty() && q2.isEmpty();     
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