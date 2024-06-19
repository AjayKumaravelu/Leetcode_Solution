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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }

        // creating a dummy variable
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Creating the variables curr , next, prev
        ListNode curr = dummy, nex = dummy, prev = dummy;

        int count = 0;
        // We are calculating the length of the linked list
        while(curr.next != null){
            curr = curr.next;
            count++;
        }

        // We are reversing the k parts inside the while loop
        while(count >= k){
            // Current is previous next
            curr = prev.next;
            // Next is current next
            nex = curr.next;

            // Traversing in the loop for reversing
            for(int i = 1; i < k; i++){
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }

            // pointing the previous to the curr
            prev = curr;
            count -= k;
        } 

        return dummy.next;
    }
}
