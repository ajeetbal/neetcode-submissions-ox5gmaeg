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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private void rightSideView(TreeNode root, List<Integer> result, int height) {
        if (root == null) {
            return;
        }

        if (height == result.size()) {
            result.add(root.val);
        }

        rightSideView(root.right, result, height + 1);
        rightSideView(root.left, result, height + 1);
    }
}
