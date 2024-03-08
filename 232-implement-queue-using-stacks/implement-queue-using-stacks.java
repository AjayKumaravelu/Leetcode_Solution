class MyQueue {
    // We are declaring two stacks
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();   
    }
    
    public void push(int x) {
        s1.push(x);    
    }
    
    public int pop() {
    if(s2.isEmpty()){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }

    if(!s2.isEmpty()){
        return s2.pop();
    }
    else{
        // Handle empty queue scenario
        //throw new NoSuchElementException("The queue is empty");
        return -1;
    }   
}
    
    public int peek() {
    if (s2.isEmpty()) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    if (!s2.isEmpty()) {
        int front = s2.peek(); // Return the top element of s2 without removing it
        return front;
    } else {
        //throw new NoSuchElementException("The queue is empty");
        return -1;
    }
}
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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