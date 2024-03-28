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
    public ListNode reverse(ListNode start, ListNode end){
        ListNode current = start.next;
        ListNode prev = start;
        ListNode first = current;

        while(current != end){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        start.next = prev;
        first.next = current;
        return first;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null && k < 1){
            return head;
        }
        ListNode dNode = new ListNode(0);
        dNode.next = head;

        ListNode start = dNode;
        ListNode end = head;
        int count = 0;

        while(end != null){
            count++;
            if(count % k == 0){
                start = reverse(start,end.next);
                end = start.next;
            }
            else{
                end = end.next;
            }
        }
        return dNode.next;
    }
}