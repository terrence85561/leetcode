package com.company.Lists;

import java.util.HashSet;

public class LC142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        /*
            hash map
         */
        HashSet<ListNode> visited = new HashSet<>();

        while(head != null){
            if(visited.contains(head)) return head;
            visited.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycleWithTwoPtr(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast. next.next;
            slow = slow.next;

            if(slow == fast) {
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            };
        }

        return null;
    }
}
