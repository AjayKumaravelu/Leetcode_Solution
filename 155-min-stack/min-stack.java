class MinStack {
    Stack <Long> st = new Stack<Long>();
    Long min;

    public MinStack() {
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long Val = Long.valueOf(val);
        if(st.isEmpty()){
            st.push(Val);
            min = Val;
        }
        else{
            if(Val<min){
                // we will insert the updated value into the stack
                st.push(2*Val-min);
                min = Val;
            }
            else{
                st.push(Val);
            }
        }
   
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        Long val = st.pop();
        if(val<min){
            // if val is lesser than minimum then we are reseting the minimum to previous minimum
            min = 2*min - val;
        }
        
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        Long val = st.peek();
        if(val < min){
            // if value lesser than minimum then we will return the min
            return min.intValue();
        }
        return val.intValue();
        
    }
    
    public int getMin() {
        return min.intValue();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */