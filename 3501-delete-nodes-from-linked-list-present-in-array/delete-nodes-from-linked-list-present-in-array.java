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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Step 1: Store nums array values in a HashSet for fast lookup
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Step 2: Create a dummy node to simplify edge cases (e.g., when head needs to be deleted)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Step 3: Traverse the linked list and remove nodes with values in numSet
        while (current.next != null) {
            if (numSet.contains(current.next.val)) {
                // Skip the node if its value is in nums
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // Return the modified linked list starting from dummy.next
        return dummy.next;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}