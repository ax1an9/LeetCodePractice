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
class Solution {//性质：平衡二叉树中序遍历是一个单调序列
    int last=0;//最后遍历的元素val
    boolean hasLast=false;//之前是否有元素
    public boolean isValidBST(TreeNode root) {
        //中序遍历 左中右
        return helper(root);
    }
    boolean helper(TreeNode root){
        if(root==null){//空，默认为true
            return true;
        }
        if(!helper(root.left)){//左侧节点遍历
            return false;
        }
        //当前节点处理
        if(!hasLast){
            hasLast=!hasLast;
            last=root.val;
        }else{
            if(root.val<=last){//保证新节点的值大于旧节点
                return false;
            }else{
                last=root.val;
            }
        }
        if(!helper(root.right)){//右侧节点遍历
            return false;
        }
        return true;//左中右都遍历完后符合条件返回true
    }
}
