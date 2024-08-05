/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestorHelper(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        // return the node if it matches with p or q
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        // check if the node exist on left and right side
        TreeNode left = lowestCommonAncestorHelper(root.left, p, q);
        TreeNode right = lowestCommonAncestorHelper(root.right, p, q);

        // if left and right both are non null then root should be the LCA
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else { // right != null
            return right;
        }
    }

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        return lowestCommonAncestorHelper(root, p, q);
    }
}
