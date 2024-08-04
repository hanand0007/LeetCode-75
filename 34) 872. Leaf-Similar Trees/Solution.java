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

    public List<Integer> getLeafNodeList(TreeNode root) {
        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            return list;
        }
        List<Integer> res = new ArrayList<>();
        if (root.left != null) {
            res = getLeafNodeList(root.left);
        }
        if (root.right != null) {
            res.addAll(getLeafNodeList(root.right));
        }
        return res;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeafNodeList(root1).equals(getLeafNodeList(root2));
    }
}
