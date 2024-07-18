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
    int count = 0;

    public int countPairs(TreeNode root, int distance) {
        count = 0;
        dfs(root, distance);
        return count;
    }

    private List<Integer> dfs(TreeNode node, int distance) {
        List<Integer> distances = new ArrayList<>();
        if (node == null) return distances;
        
        if (node.left == null && node.right == null) {
            distances.add(1);
            return distances;
        }

        List<Integer> leftDistances = dfs(node.left, distance);
        List<Integer> rightDistances = dfs(node.right, distance);

        for (int ld : leftDistances) {
            for (int rd : rightDistances) {
                if (ld + rd <= distance) {
                    count++;
                }
            }
        }

        for (int ld : leftDistances) {
            if (ld + 1 < distance) {
                distances.add(ld + 1);
            }
        }
        for (int rd : rightDistances) {
            if (rd + 1 < distance) {
                distances.add(rd + 1);
            }
        }

        return distances;
    }
}