# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        #         if not head:
        #             return head
        #         if not head.next:
        #             return head
        #         newHead = self.reverseList(head.next)
        #         head.next.next = head
        #         head.next = None

        #         return newHead

        # iterative
        if not head:
            return head
        if not head.next:
            return head
        newHead = None
        cur_node = head
        while(cur_node):
            next_node = cur_node.next
            cur_node.next = newHead
            newHead = cur_node
            cur_node = next_node

        return newHead
