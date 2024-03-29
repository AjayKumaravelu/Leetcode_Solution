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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    private void inorder(TreeNode root){
        // Base condition
        if(root == null){
            return;
        }
        inorder(root.left);
        
        // We are checking the condition to be inorder in which root.val > prev.val if it is false we are going into this if loop
        if(prev != null && root.val < prev.val){
            // Checking whether the first is null 
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);

    }

    public void recoverTree(TreeNode root) {
        // Initialising the first,middle,last
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        
        // Swapping first and last
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        //Swapping first and middle ---> when the swapping in adjacent nodes
        else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}