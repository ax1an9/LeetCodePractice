/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode a=headA,b=headB;
        while(a!=b){
            //如果a到达null，那么下一跳为headB，继续循环，直到b也达到null，并且置为headA
            //此时a，b离交点的距离相同
            //若不相交则a，b离null的位置相同
            a= a==null? headB:a.next;
            b= b==null? headA:b.next;
        }
        //循环直到a==b，此时要么到null要么到目标节点，返回a/b任意一个都满足题意
        return a;
    }
}
