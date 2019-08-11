package com.company.Tree;

public class LC109_sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(temp);
        return root;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(-10);
        root.next = new ListNode(-3);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = new ListNode(9);

        LC109_sortedListToBST L = new LC109_sortedListToBST();
        TreeNode res = L.sortedListToBST(root);
        System.out.println(res.val);

    }
}

