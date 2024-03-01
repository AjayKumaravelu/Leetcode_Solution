class StockSpanner {
    private Stack<int []> stack;
    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        // Initializing count to 1
        int count = 1;
        // while loop run until the stack is empty and price at top is lesser or equal to price
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            // We pop the top most element
            count += stack.pop()[1];
        }
        // We are creating a new array containing the corresponding price and its corresponding span
        stack.push(new int[]{price,count});
        // We are returning the calculated span
        return count;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */