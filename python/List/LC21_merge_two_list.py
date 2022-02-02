
class Solution:

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1
        if(l1.val < l2.val):
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

    # def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
    #     dummyhead = ListNode(-1)
    #     cur = dummyhead
    #     while(l1 or l2):
    #         if not l1:
    #             cur.next = l2
    #             return dummyhead.next
    #         if not l2:
    #             cur.next = l1
    #             return dummyhead.next

    #         if l1.val <= l2.val:
    #             cur.next = l1
    #             l1 = l1.next
    #         else:
    #             cur.next = l2
    #             l2 = l2.next
    #         cur = cur.next
    #     return dummyhead.next
