class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        // New array to store the ans
        int[] ans = new int[n - k + 1];
        int ansi = 0;

        // We will declare dequeue -- we will store index;
        Deque<Integer> dq = new ArrayDeque<>();

        // We will traverse the array
        for(int i = 0; i < n; i++){
            // We will remove the element which is out of bound from subarray
            if(!dq.isEmpty() && dq.peek() == i - k){
                dq.poll();
            }

            // We will traverse the and remove smaller element in k range
            while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]){
                dq.pollLast();
            }

            dq.offer(i);

            // We will start calculating answer from k - 1 index;
            if(i >= k - 1){
                ans[ansi++] = a[dq.peek()];
            }

        }
        
        return ans;
    }
}