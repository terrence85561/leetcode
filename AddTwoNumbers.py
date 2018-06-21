class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        begin = ListNode(0)
        current = begin


        while l1 != None or l2 != None:
            if l1 != None:
                first = l1.val
            else:
                first = 0
            if l2 != None:
                second = l2.val
            else:
                second = 0

            sums = first + second + carry
            if sums >= 10:
                carry = 1
            else:
                carry = 0

            result = sums%10

            current.next = ListNode(result)
            current = current.next

            if l1 != None:
                l1 = l1.next
            if l2 != None:
                l2 = l2.next

        if carry > 0:
            temp = ListNode(1)
            current.next = temp

        return begin.next
