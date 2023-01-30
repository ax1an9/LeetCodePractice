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
    public int findBottomLeftValue(TreeNode root) {
        //层序遍历，每轮的第一个都有可能是结果
        //如果没有新的元素那么结果就产生了
        Deque<TreeNode> deque =new LinkedList<>();
        deque.offer(root);
        int res=root.val;
        while(!deque.isEmpty()){
            int n=deque.size();
            for(int i=0;i<n;i++){
                TreeNode poll=deque.poll();
                if(i==0){
                    res=poll.val;
                }
                if(poll.left!=null){
                    deque.offer(poll.left);
                }
                if(poll.right!=null){
                    deque.offer(poll.right);
                }
            }
        }
        return res;

    }
}
