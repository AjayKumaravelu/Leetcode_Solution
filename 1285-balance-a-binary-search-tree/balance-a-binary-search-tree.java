/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void inorderTraversal(TreeNode root, List<Integer> sortedList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, sortedList);
        sortedList.add(root.val);
        inorderTraversal(root.right, sortedList);
    }

    // Construct a balanced BST from sorted elements
    private TreeNode sortedListToBST(List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = sortedListToBST(sortedList, start, mid - 1);
        node.right = sortedListToBST(sortedList, mid + 1, end);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);
        return sortedListToBST(sortedList, 0, sortedList.size() - 1);
        
    }
}