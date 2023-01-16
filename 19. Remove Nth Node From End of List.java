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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;
        for(int i=0;i<n+1;i++){//快指针移动n+1步
            fast=fast.next;
        }
        while(fast!=null){//只要快指针非空，快慢指针一起移动
            fast=fast.next;
            slow=slow.next;
        }
        //此时slow指向要删除元素的前一个，直接删除
        slow.next=slow.next.next;
        return dummy.next;
    }
}
