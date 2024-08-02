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
    public TreeNode build(int[] inorder,int startin, int endin, int[] postorder, int startpos, int endpos, HashMap<Integer, Integer> map){
        if(startin > endin || startpos > endpos){
            return null;
        }

        TreeNode root = new TreeNode(postorder[endpos]);
        int inorderroot = map.get(postorder[endpos]);
        int numsleft = inorderroot - startin;

        root.left = build(inorder, startin, inorderroot - 1, postorder, startpos, startpos + numsleft - 1, map);
        root.right = build(inorder, inorderroot + 1, endin, postorder, startpos + numsleft , endpos - 1, map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
}