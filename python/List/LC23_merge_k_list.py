# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        import heapq
        ListNode.__eq__ = lambda self, other: self.val == other.val
        ListNode.__lt__ = lambda self, other: self.val < other.val
        dummy = ListNode(-1)
        cur = dummy
        heap = []
        
        for l in lists:
            
            if l:
                heapq.heappush(heap,(l.val, l))
        while len(heap) != 0:
            val, node = heapq.heappop(heap)
            cur.next = ListNode(val)
            cur = cur.next
            node = node.next
            if node:
                heapq.heappush(heap, (node.val, node))
        return dummy.next