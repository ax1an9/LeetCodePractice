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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null){//根節點為空，不存在任何路徑，直接返回
            return res;
        }
        helper(root,targetSum,res,new LinkedList<>());
        return res;
    }
    /*
    構建可能的路徑
    root：當前節點
    targetSum：當前需要的val
    res：最終結果的引用
    temo：存儲之前已經選擇的節點的值
     */
    void helper(TreeNode root, int targetSum,List<List<Integer>>res,LinkedList<Integer>temp){
        if(root==null){
            if(targetSum==0){
                res.add(new LinkedList<>(temp));
            }
            return ;
        }
        //對於非空節點
        temp.addLast(root.val);//選擇
        if(root.right==null&&root.left==null){//葉子節點：只需要進行一次helper
            helper(root.right,targetSum-root.val,res,temp);//left or right is OK
        }else{
            if(root.left!=null) helper(root.left,targetSum-root.val,res,temp);
            if(root.right!=null) helper(root.right,targetSum-root.val,res,temp);        
        } 
        temp.removeLast();//撤銷選擇 
    }
}
