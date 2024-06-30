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
    public static void preorder(TreeNode root, List<Integer> arr){
        // preorder Traversal ---> root left right
        if(root == null){
            return;
        }

        arr.add(root.val);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }

    /*public List<Integer> preorderTraversal(TreeNode root) {
        // preorder Traversal --->  root left right
        List<Integer> arr = new ArrayList<>();
        preorder(root, arr);
        return arr;
    }*/

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        // pointer to the current node
        TreeNode curr = root;

        while(curr != null){
            // Case 1 when the left is null
            if(curr.left == null){
                preorder.add(curr.val);
                curr = curr.right;
            }
            // Case 2 when there is left we will go to the rightmost element and point it o current and move the current
            else{
                TreeNode prev = curr.left;
                // We are checking whether it is threaded
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                // previous right is null
                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                }
                // if not null that is connected to current then we will break the thread
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
}