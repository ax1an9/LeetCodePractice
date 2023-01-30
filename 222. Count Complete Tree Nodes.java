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
    public int countNodes(TreeNode root) {//利用完全二叉樹的性質
        if(root==null){//邊界：空
            return 0;
        }
        int leftDepth=0;//向左側下降的深度
        int rightDepth=0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        while(left!=null){
            left=left.left;
            leftDepth++;
        }
        while(right!=null){
            right=right.right;
            rightDepth++;
        }
        if(rightDepth==leftDepth){//從某個節點向左右側下降深度相同，説明該樹是滿二叉樹，邊界：單節點的也是滿二叉樹
            return (2<<rightDepth)-1;//2^（包括根在内的樹深度） - 1 == 滿二叉樹的節點個數
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
