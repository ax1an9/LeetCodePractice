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
  /*
  平衡二叉树：左右子树高度差最多为1
  空节点对高度的贡献为0
  */
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;//自底向上
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);//左子树的高度
        if(left == -1) return -1;//-1说明不平衡
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
