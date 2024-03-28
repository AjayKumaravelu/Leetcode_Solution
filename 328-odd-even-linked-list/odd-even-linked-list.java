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
    static ListNode head, tail;

    public void InsertAtLast(int Value){
        ListNode newNode = new ListNode();
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail = tail.next = newNode;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = new ListNode(-1);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode evenTail = evenHead;
        //ListNode curr = head, temp;

        ListNode curr = head;
        int index = 1; // Index of current node, starting from 1

        while( curr!= null){
            ListNode next = curr.next; // Save next pointer before modifying curr.next
            curr.next = null; // Break the link
            // we are breaking the link
            /*temp = curr;
            curr = curr.next;
            temp.next = null;*/

            //Checking condition
            if(index % 2 != 0){
                oddTail.next = curr;
                oddTail = curr;
                
            }
            else{
                evenTail.next = curr;
                evenTail = curr;
            }
            curr = next;
            index++;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}