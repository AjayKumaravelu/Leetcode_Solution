/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        // We are initializing the three variables 
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;

        // Step 1:  We are finding the colliding point where the fast == slow
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                // Step 2: move the entry and slow by 1 until it collide the point which collide form the cycle
                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}