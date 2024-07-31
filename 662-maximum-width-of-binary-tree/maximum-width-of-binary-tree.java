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

class Pair{
    int num;
    TreeNode node;
    Pair(int num, TreeNode node){
        this.num = num;
        this.node = node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // If the root is null return 0
        if( root == null ) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));

        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;
            int first = 0, last = 0;

            for(int i = 0; i < size; i++){
                int curr_id = q.peek().num - mmin;
                TreeNode node = q.peek().node;
                q.poll();

                if(i == 0) first = curr_id;
                if(i == size - 1) last = curr_id;

                if(node.left != null){
                    q.offer(new Pair(curr_id * 2 + 1, node.left));
                }
                if(node.right != null){
                    q.offer(new Pair(curr_id * 2 + 2, node.right));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}