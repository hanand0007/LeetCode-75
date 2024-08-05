/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int max = 0;

    public int longestZigZag(TreeNode root) {
        return maxZigZag(root, -1); // direction is -1 for root
    }

    public int maxZigZag(TreeNode node, int direction) {
        // direction = 0, left
        // direction = 1, right
        if (node == null) {
            return 0;
        }

        int left = maxZigZag(node.left, 0);
        int right = maxZigZag(node.right, 1);
        if (direction == 0) {
            max = Math.max(max, right + 1);
            return right + 1;
        }
        if (direction == 1) {
            max = Math.max(max, left + 1);
            return left + 1;
        }
        return max;
    }
}
