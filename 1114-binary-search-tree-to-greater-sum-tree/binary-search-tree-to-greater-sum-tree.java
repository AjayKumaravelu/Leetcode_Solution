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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        // Reverse in-order traversal to accumulate the sums
        traverse(root);
        return root;
    }
    
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // Traverse the right subtree first
        traverse(node.right);
        
        // Update the sum and the current node's value
        sum += node.val;
        node.val = sum;
        
        // Traverse the left subtree
        traverse(node.left);
    }
}