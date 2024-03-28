 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // Method to reverse a sublist of the linked list from start to end (excluding end)
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode current = start.next; // Current node to be reversed
        ListNode prev = start; // Previous node of current
        ListNode first = current; // Save the first node of the reversed sublist
        
        // Reverse the sublist from start to end
        while (current != end) {
            ListNode temp = current.next; // Save the next node
            current.next = prev; // Reverse the pointer direction
            prev = current; // Move prev to current
            current = temp; // Move current to next
        }

        // Connect the start of the sublist to the last node of the reversed sublist
        start.next = prev;
        // Connect the first node of the reversed sublist to the node after the end
        first.next = current;
        
        // Return the first node of the reversed sublist
        return first;
    }

    // Method to reverse the linked list in groups of size k
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        
        // Create a dummy node and connect it to the head
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode start = dummyNode; // Points to the start of each sublist
        ListNode end = head; // Points to the end of each sublist
        int count = 0; // Counter to keep track of nodes processed
        
        // Traverse the list
        while (end != null) {
            count++; // Increment the counter
            if (count % k == 0) { // If the count is a multiple of k
                // Reverse the sublist from start to end
                start = reverse(start, end.next);
                end = start.next; // Move end to the start of the next sublist
            } else {
                end = end.next; // Move end to the next node
            }
        }
        
        // Return the modified list
        return dummyNode.next;
    }
}
