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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        // Now we will find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the list which is after middle element
        slow.next = reverseList(slow.next);

        slow = slow.next;
        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode newHead =  null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}