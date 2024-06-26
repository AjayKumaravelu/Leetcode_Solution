class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each element in nums2
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Stack to help find the next greater element
        Stack<Integer> stack = new Stack<>();
        
        // Traverse nums2 from the end to the beginning
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];
            // Ensure stack only has elements greater than the current element
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            // If stack is not empty, the top element is the next greater element
            if (!stack.isEmpty()) {
                nextGreaterMap.put(current, stack.peek());
            } else {
                nextGreaterMap.put(current, -1);
            }
            // Push current element onto the stack
            stack.push(current);
        }
        
        // Build the result for nums1 based on the nextGreaterMap
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        
        return result;
    }
}