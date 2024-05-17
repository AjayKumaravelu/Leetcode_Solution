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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // Base case: if the root is null, return null
        if (root == null) {
            return null;
        }

        // Recursively call the function on the left and right children
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // After the recursive calls, check if the current node is a leaf node with the target value
        if (root.left == null && root.right == null && root.val == target) {
            return null; // Remove the current leaf node by returning null
        }

        // Return the root after the potential removals
        return root;
    }
}