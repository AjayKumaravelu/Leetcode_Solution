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
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases
        if(head == null || head.next == null || k == 0){
            return head;
        }

        // Finding the length of the list
        ListNode curr = head;
        int length = 1;
        while(curr.next != null){
            curr = curr.next;
            length++;
        }

        // We will make it circular by pointing the last node ot the head
        curr.next = head;

        // Now we will traverse (length - k) to find the last node in rotated array and point that to null
        k = k % length;
        k = length - k;

        while(k > 0){
            curr = curr.next;
            k--;
        }

        /// We will break the link
        head = curr.next;
        curr.next = null;

        return head;
    }
}