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
    public ListNode detectCycle1(ListNode head) {
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


    public ListNode detectCycle(ListNode head){
        // Here first we are finding whether the linked list is cyclic or not
        // Here We are going to use Slow and Fast Pointer Approach 
        // The concept which we are using is like The point which slow and fast pointer meet
        // let us decode that point Slow moves L distance and Fast moves 2L distance
        // Difference is d now the point where the loop starts will be L - d 
        // from that point we will move slow and fast by 1
        // When they meet it is the start point of the loop

        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                // I will again point the slow to the head
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            
        }
        return null;

        
    }
}