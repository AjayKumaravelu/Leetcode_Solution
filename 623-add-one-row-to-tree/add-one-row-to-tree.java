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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        dfs(root, val, depth, 1);
        return root;
    }
    
    private void dfs(TreeNode node, int val, int depth, int currentDepth) {
        if (node == null) return;
        
        if (currentDepth == depth - 1) {
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            newLeft.left = node.left;
            newRight.right = node.right;
            node.left = newLeft;
            node.right = newRight;
        } else {
            dfs(node.left, val, depth, currentDepth + 1);
            dfs(node.right, val, depth, currentDepth + 1);
        }
    }
}