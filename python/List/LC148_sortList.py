class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        # Top-down O(nLogn) time, O(logn) space for recursion
        if head == None or head.next == None:
            return head
        slow = head
        fast = head
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next

        second = slow.next
        slow.next = None
        first_half = self.sortList(head)
        second_half = self.sortList(second)
        return self.merge(first_half, second_half)

    def merge(self, first, second):
        dummy = ListNode(-1)
        cur = dummy
        while(first or second):
            if first == None:
                cur.next = second
                second = None
            elif second == None:
                cur.next = first
                first = None

            elif first.val <= second.val:
                cur.next = first
                cur = cur.next
                first = first.next
            else:
                cur.next = second
                cur = cur.next
                second = second.next
        return dummy.next
