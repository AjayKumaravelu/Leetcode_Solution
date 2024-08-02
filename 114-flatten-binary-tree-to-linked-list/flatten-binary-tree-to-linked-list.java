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
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        // We will traverse until the curr becomes null
        while(curr != null){
                if(curr.left != null){
                    TreeNode prev = curr.left;

                    // We will traverse untill the last node in left subtree 
                    while(prev.right != null){
                        prev = prev.right;
                    }

                    // Then we will point the prev.right  to the curr.right and curr.right to curr.left and we have to make cuur.left == null
                    prev.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                }
                curr = curr.right;
        }

    }
}