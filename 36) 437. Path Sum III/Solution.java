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

    int count;
    Map<Long, Integer> map;

    public void pathSumHelper(TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (map.get(sum - targetSum) != null) {
            count += map.get(sum - targetSum);
        }
        if (targetSum == sum) {
            count++;
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        pathSumHelper(root.left, targetSum, sum);
        pathSumHelper(root.right, targetSum, sum);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        map = new HashMap<>();
        pathSumHelper(root, targetSum, 0);
        return count;
    }
}
