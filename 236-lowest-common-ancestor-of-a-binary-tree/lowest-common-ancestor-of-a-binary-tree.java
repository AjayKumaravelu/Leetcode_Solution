/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or either p or q is found, return root
        if(root == null || root == p || root == q){
            return root;
        }
        
        // Recursively search for p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        // As the left is null return right
        if(left == null){
            return right;
        }
        // As right is null then returen left
        else if(right == null){
            return left;
        }
        // both left and right  are found then we got the answer
        else{
            return root;
        }

    }
}