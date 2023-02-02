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
    TreeNode pre=null;
    public TreeNode convertBST(TreeNode root) {//右中左遍历，采用pre保存之前节点，每次都加上上个节点的值。（init pre时不需要）
        if(root==null){
            return null;
        }
        convertBST(root.right);
        if(pre==null){
        }else{
            root.val+=pre.val; 
        }
        pre=root;
        convertBST(root.left);
        return root;
    }

}
