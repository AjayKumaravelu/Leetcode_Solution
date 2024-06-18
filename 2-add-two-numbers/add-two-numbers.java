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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Let us create a dummy node
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry == 1){
            int sum = 0;
            // add l1 value
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            // add l2 value
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            // add carry if any
            sum += carry;
            carry = sum / 10;
            // create a new Node
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
    }
}