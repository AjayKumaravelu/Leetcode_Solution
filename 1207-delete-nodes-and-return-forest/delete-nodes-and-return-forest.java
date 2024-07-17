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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();
        helper(root, toDeleteSet, forest, true);
        return forest;
    }

    private TreeNode helper(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest, boolean isRoot) {
        if (node == null) {
            return null;
        }

        boolean deleted = toDeleteSet.contains(node.val);
        if (isRoot && !deleted) {
            forest.add(node);
        }

        node.left = helper(node.left, toDeleteSet, forest, deleted);
        node.right = helper(node.right, toDeleteSet, forest, deleted);

        return deleted ? null : node;
    }

    // Utility function to print the forest for verification
    public void printForest(List<TreeNode> forest) {
        for (TreeNode root : forest) {
            printTree(root);
            System.out.println();
        }
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}