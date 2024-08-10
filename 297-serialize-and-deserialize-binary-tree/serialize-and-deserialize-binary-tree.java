/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Edge case
        if(root == null) return "";

        // Declare the StringBuilder which stores the result and the queue for level order traversal
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        // Then we will traverse by level order and do necessary changes
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node == null){
                s.append("#,");
            }
            else{
                s.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // if data is empty then return null
        if(data == "") return null;

        // We need a queue and then string array;
        String[] values = data.split(",");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i = 1; i < values.length; i++){
            TreeNode parent = q.poll();

            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            } 
            if(++i < values.length && !values[i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            } 
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));