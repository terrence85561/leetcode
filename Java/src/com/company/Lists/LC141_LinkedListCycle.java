package com.company.Lists;

import java.util.HashSet;

public class LC141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        /*
            using hash map
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
}
