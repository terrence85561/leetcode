# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8
# Explanation: 342 + 465 = 807.
class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummyhead = ListNode(0)
        temp1 = l1
        temp2 = l2
        current = dummyhead
        sum = 0
        while(temp1 != None or temp2 != None):
            if temp1 != None:
                sum += temp1.val
                temp1 = temp1.next
            if temp2 != None:
                sum += temp2.val
                temp2 = temp2.next

            current.next = ListNode(sum%10)
            sum //= 10
            current = current.next

        if sum == 1:
            current.next = ListNode(1)

        return dummyhead.next
