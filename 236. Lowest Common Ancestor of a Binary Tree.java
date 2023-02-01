/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
        回溯：后续遍历最后处理当前节点，因此方便将更深层次的节点的信息进行操作
        本题正是利用这一特点，将采用DFS找 p q 然后将公共祖先的信息不断向上传递 */
        if(root==null){//对于空节点 没有lowestCommonAncestor
            return null;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);//求解左树中的结果
        TreeNode right=lowestCommonAncestor(root.right,p,q);//右数
        if(root==p||root==q){//发现p/q，传回当前节点
            return root;
        }
        if(left!=null&&right!=null){//如果左右都返回发现p 或 q，说明 pq 都找到了，这个节点就是结果
            return root;
        }
        //对于 单独 p或q对应 root 向上传递
        if(left!=null){
            return left;
        }
        return right;
    }
}
