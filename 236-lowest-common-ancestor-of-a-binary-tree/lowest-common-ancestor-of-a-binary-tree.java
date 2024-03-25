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
        
        // If both left and right subtrees return non-null, root is LCA
        if(left != null && right != null){
            return root;
        }
        // LCA found in left subtree
        else if(left != null){
            return left;
        }
        // LCA found in right subtree
        else{
            return right;
        }

    }
}