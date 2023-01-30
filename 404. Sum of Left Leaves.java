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
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        lHelper(root.left);
        rHelper(root.right);
        return sum;
    }
    void lHelper(TreeNode root){//遍历左子树
        if(root==null)return;
        if(root.left==null&&root.right==null){//左遍历遇到叶子
            sum+=root.val;
            return;
        }
        if(root.right!=null)rHelper(root.right);
        if(root.left!=null)lHelper(root.left);
        
    }
    void rHelper(TreeNode root){//遍历右子树
        if(root==null) return;
        lHelper(root.left);
        rHelper(root.right);
    }
}
