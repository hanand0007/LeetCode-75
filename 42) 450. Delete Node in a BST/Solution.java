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

    public TreeNode deleteNodeHelper(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) { // search value in left subtree
            root.left = deleteNodeHelper(root.left, key);
        } else if (root.val < key) { // search value in right subtree
            root.right = deleteNodeHelper(root.right, key);
        } else {
            // value found at root
            if (root.left == null) { // if root.left is null return right node
                return root.right;
            } else if (root.right == null) { // if root.right is null return left node
                return root.left;
            } else { // if nono of them is null, find the smallest node in the right subtree
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                // copy the smallest value to current node
                root.val = cur.val;
                // delete the smallest value from right subtree
                root.right = deleteNodeHelper(root.right, root.val);
            }
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNodeHelper(root, key);
    }
}
