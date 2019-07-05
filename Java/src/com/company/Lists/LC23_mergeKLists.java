package com.company.Lists;

import java.util.*;

public class LC23_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
            using min-heap/ priority queue
         */
        if (lists == null || lists.length == 0) return null;

        int sizes = lists.length;

        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<>(sizes, cmp);

        for (int i = 0; i < sizes; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;

        while (pq.size() != 0) {
            ListNode node = pq.poll();
            curNode.next = node;
            curNode = node;
            if (curNode.next != null) {
                pq.add(curNode.next);
            }
        }

        return dummy.next;

    }

    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        // merge sort
        return null;
    }

    public ListNode mergeKListsBF(ListNode[] lists){
        List<Integer> all = new ArrayList<>();
        for(int i = 0; i < lists.length; i++){
            ListNode cur = lists[i];
            while(cur != null){
                all.add(cur.val);
                cur = cur.next;
            }
        }

        Collections.sort(all);

        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        for(Integer i : all){
            ListNode newNode = new ListNode(i);
            curNode.next = newNode;
            curNode = curNode.next;
        }
        return dummy.next;
    }
}