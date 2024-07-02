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
    public boolean isBalanced(TreeNode root) {
        return dfsheight(root) != -1;
    }

    int dfsheight(TreeNode root){
        // if root is null return 0
        if(root == null){
            return 0;
        }

        // finding left height
        int left = dfsheight(root.left);
        if(left == -1){
            return -1;
        }

        // finding right height
        int right = dfsheight(root.right);
        if(right == -1){
            return -1;
        }

        // if the left - right > 1 it is not balanced
        if(Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}