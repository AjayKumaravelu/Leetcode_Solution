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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        // Iterate through descriptions to build the tree
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            // Get or create parent node
            TreeNode parent = map.getOrDefault(parentVal, new TreeNode(parentVal));
            map.put(parentVal, parent);

            // Get or create child node
            TreeNode child = map.getOrDefault(childVal, new TreeNode(childVal));
            map.put(childVal, child);

            // Link parent and child
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            // Mark the child node
            children.add(childVal);
        }

        // The root is the only node that is not a child
        TreeNode root = null;
        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                root = map.get(val);
                break;
            }
        }

        return root;
    }

    // Helper method to print the tree (for testing purposes)
    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    
    }
}