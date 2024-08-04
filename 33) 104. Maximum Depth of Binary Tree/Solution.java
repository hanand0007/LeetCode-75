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

    public int maxDepthHelper(TreeNode root) {
        if (root == null) return 0;
        int left = 1 + maxDepthHelper(root.left);
        int right = 1 + maxDepthHelper(root.right);
        return Math.max(left, right);
    }

    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root);
    }
}
