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
        // if the root is null return null
        if(root == null) return null;

        // Assign root.val to curr
        int curr = root.val;

        // If the curr < p.val && curr < q.val then it lies in right
        if(curr < p.val && curr < q.val) return lowestCommonAncestor(root.right, p, q);
        // If the curr > p.val && curr > q.val then it lies in left
        if(curr > p.val && curr > q.val) return lowestCommonAncestor(root.left, p, q);
        // else we will return root
        return root;

    }
}