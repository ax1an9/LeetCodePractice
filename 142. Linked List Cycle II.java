/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head,slow=head;//快慢指针
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){//如果链表有终点，无环
            return null;
        }
        ListNode temp=head;
        while(temp!=slow){//此时temp和slow离交叉点的位置相同
            temp=temp.next;
            slow=slow.next;
        }
        return slow;

    }
}
