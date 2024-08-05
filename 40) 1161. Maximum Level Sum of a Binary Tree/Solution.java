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

    List<Long> levelSum;

    public void maxLevelSumHelper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= levelSum.size()) {
            levelSum.add(0l);
        }
        levelSum.set(level, levelSum.get(level) + root.val);
        maxLevelSumHelper(root.left, level + 1);
        maxLevelSumHelper(root.right, level + 1);
    }

    public int maxLevelSum(TreeNode root) {
        levelSum = new ArrayList<>();
        maxLevelSumHelper(root, 0);
        long maxSum = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < levelSum.size(); i++) {
            if (levelSum.get(i) > maxSum) {
                maxSum = levelSum.get(i);
                ans = i;
            }
        }
        return ans + 1;
    }
}
