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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    // using level order traversal
    // public int maxDepth(TreeNode root) {
    //     // We will use queue data structure
    //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //     //List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
    //     int level = 0;
    //     if(root == null){
    //         return level;
    //     }

    //     // we will push the root first
    //     queue.offer(root);

    //     while(!queue.isEmpty()){
    //         int levelnum = queue.size();
    //         List<Integer> sublist = new LinkedList<Integer>();
    //         // we will traverse till levelnum
    //         for(int i = 0; i < levelnum; i++){
    //             if(queue.peek().left != null) queue.offer(queue.peek().left);
    //             if(queue.peek().right != null) queue.offer(queue.peek().right);
    //             sublist.add(queue.poll().val);
    //         }
    //         //wrapList.add(sublist);
    //         level++;
    //     }
    //     return level;
    //}
}