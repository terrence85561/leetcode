/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry;
        int sums;
        int x,y;
        int result;
        carry = 0;
        ListNode head = new ListNode(0);
        ListNode current = head;
        while(l1 != null || l2 != null){
            if(l1 != null){
                x = l1.val;
            }else{
                x = 0;
            }
            if(l2 != null){
                y = l2.val;
            }else{
                y = 0;
            }
            sums = x + y + carry;
            result = sums%10;
            current.next = new ListNode(result);
            current = current.next;
            carry = sums/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            ListNode temp = new ListNode(1);
            current.next = temp;
        }
        return head.next;

    }
}
