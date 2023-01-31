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
    Map<Integer,Integer> val_inIdx=new HashMap<>();//存儲中序數組 val 和 idx 的映射
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int size=postorder.length;
        for(int i=0;i<size;i++){//填充
            val_inIdx.put(inorder[i],i);
        }//n
        return build(inorder,postorder,0,size,0,size);

    }
    TreeNode build(int[] inorder, int[] postorder,int il,int ir,int pl,int pr){
        //從後序中取出root
        if(ir>il){
            TreeNode root=new TreeNode();
            root.val=postorder[pr-1];
            int mid=val_inIdx.get(root.val);
            root.left=build(inorder,postorder,il,mid,pl,pl+mid-il);
            root.right=build(inorder,postorder,mid+1,ir,pl+mid-il,pr-1);//記得我們取出了一個post的元素
            return root;
        }
        return null;
    }
}
