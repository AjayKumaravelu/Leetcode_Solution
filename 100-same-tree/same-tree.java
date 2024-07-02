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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if both are null
        if(p == null & q == null){
            return (p == q);
        }
        // if one is not null
        if (p == null || q == null) {
            return false;
        }

        // Using preorder Traversal ---> Root , left, Right 
        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}