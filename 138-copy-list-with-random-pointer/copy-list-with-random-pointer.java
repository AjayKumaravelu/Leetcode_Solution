/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node insertCopyInBetween(Node head){
        // We have to insert copy node in between the nodes
        Node temp = head;
        while(temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        return head;
    }

    public Node connectRandomPointer(Node head){
        // Connect the random pointer with the copy node
        Node temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
        return head;
    }

    public Node getCopy(Node head){
        // We have to point the next pointer and get the copy node
        Node dNode = new Node(-1);
        Node res = dNode;
        Node temp = head;
        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dNode.next;
    }

    public Node copyRandomList(Node head) {
        insertCopyInBetween(head);
        connectRandomPointer(head);
        return getCopy(head);
    }
}