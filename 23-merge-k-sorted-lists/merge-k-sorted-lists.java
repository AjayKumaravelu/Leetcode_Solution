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
    public ListNode mergeKLists(ListNode[] lists) {
        // Creating the priority queue with Integer and Node
        PriorityQueue<Pair<Integer,ListNode>> pq = new PriorityQueue<>((a,b)-> a.getKey()-b.getKey());
        // Traversing the list and adding it to priority Queue
        for(int i = 0 ; i < lists.length ; i++){
            if(lists[i] != null){
                // Adding integer and node to the Queue
                pq.add(new Pair<>(lists[i].val, lists[i]));
            }
        }

        //Creating a Dummy Node
        ListNode dNode = new ListNode(-1);
        // Assigning temp to dNode
        ListNode temp = dNode;
        while(!pq.isEmpty()){
            // We are getting the min value from priority Queue(min-heap)
            Pair<Integer, ListNode> pair = pq.poll();
            ListNode node = pair.getValue();
            if(node.next != null){
                // Adding the next Value to the priority Queue
                pq.add(new Pair<>(node.next.val, node.next));
            }
            // We are pointing the temp->next to that node
            temp.next = node;
            // We are moving temp to temp->next
            temp = temp.next;
        }
        return dNode.next;

    }
}