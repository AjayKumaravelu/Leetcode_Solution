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
    public List<List<Integer>> levelOrder1(TreeNode root) {
        // We will use queue data structure
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null){
            return wrapList;
        }

        // we will push the root first
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelnum = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            // we will traverse till levelnum
            for(int i = 0; i < levelnum; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            wrapList.add(sublist);
        }
        return wrapList;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        // Answer stores the answer level by level in 2d array
        List<List<Integer>> ans = new ArrayList<>();

        // Edge cases
        if(root == null){
            return ans;
        }

        // We need Queue data Structure to keep track of the node 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
            ans.add(level);

        }

        return ans;

    }
}