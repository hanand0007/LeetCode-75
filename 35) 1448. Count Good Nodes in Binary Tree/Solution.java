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

    int ans = 0;

    public void goodNodesHelper(TreeNode root, int maxValue) {
        if (root == null) {
            return;
        }
        if (root.val >= maxValue) {
            ans++;
        }
        goodNodesHelper(root.left, Math.max(root.val, maxValue));
        goodNodesHelper(root.right, Math.max(root.val, maxValue));
    }

    public int goodNodes(TreeNode root) {
        goodNodesHelper(root, Integer.MIN_VALUE);
        return ans;
    }
}
