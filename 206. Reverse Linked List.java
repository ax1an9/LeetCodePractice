/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){//边界：空链表
            return null;
        }
        if(head.next==null){//边界：单个元素
            return head;
        }
        ListNode temp=head.next;//存储next节点
        ListNode res=reverseList(temp);//反转以next为头部的链表
        temp.next=head;//此时next已经在尾部，将head放入
        head.next=null;//head成为尾部，head.next置空
        return res;
    }
    /*
    //迭代法
    ListNode pre=null;//反转后的链表头
        ListNode cur=head;//当前链表头
        while(cur!=null){
            ListNode next=cur.next;
            if(pre==null){//初始化操作
                pre=cur;
                cur.next=null;
            }else{//直接插在pre的头部
                cur.next=pre;
                pre=cur;
            }
            cur=next;//将cur换为之前保存好的next
        }
        return pre;
     */

}
