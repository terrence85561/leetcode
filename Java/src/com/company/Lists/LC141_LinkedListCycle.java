package com.company.Lists;

import java.util.HashSet;

public class LC141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        /*
            using hash set
            space o(n)
            time o(n)
        */

        HashSet<ListNode> visited = new HashSet<>();
        while(head != null){
            if(visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        return false;

    }

    public boolean hasCycleWithTwoPtrs(ListNode head){
        /*
            using fast & slow ptr
            space O(1)
            time O(n)
            fast ptr move 2 step forward at a time
            slow ptr move one step
            if has cycle, they will meet.
         */

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) return true;


        }

        return false;

    }
}
