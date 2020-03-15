def swapPairs(self, head: ListNode) -> ListNode:
        # dummy = ListNode(-1)
        # dummy.next = head
        # cur = dummy
        # while(cur and cur.next):
        #     if not cur.next.next:
        #         return dummy.next
        #     a = cur.next
        #     b = a.next
        #     nx = b.next
        #     cur.next = b
        #     b.next = a
        #     a.next = nx
        #     cur = a
        # return dummy.next
        if not head or not head.next:
            return head
        nextNode = self.swapPairs(head.next.next)
        tmp = head.next
        tmp.next = head
        head.next = nextNode
        return tmp
