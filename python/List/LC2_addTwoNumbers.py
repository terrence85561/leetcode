class ListNode:
    def __init__(self, val):
        self.value = val
        self.next = None

def create_list(arr):
    if len(arr) == 0:
        return None
    head = ListNode(arr[0])
    head.next = create_list(arr[1:])
    return head


"""
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
"""


def addTwoNumbers(l1, l2):
    dummy_head = ListNode(-1)
    cur_node = dummy_head
    carry = 0
    while(l1 or l2):
        if l1:
            carry += l1.value
            l1 = l1.next
        if l2:
            carry += l2.value
            l2 = l2.next

        cur_node.next = ListNode(carry % 10)

        carry = carry // 10
        cur_node = cur_node.next

    if carry != 0:
        cur_node.next = ListNode(carry)

    return dummy_head.next


if __name__ == "__main__":
    # l1 = ListNode(2)
    # l2 = ListNode(5)
    # l1_cur = l1
    # l2_cur = l2
    # l1_cur.next = ListNode(4)
    # l1_cur.next.next = ListNode(3)
    # l2_cur.next = ListNode(6)
    # l2_cur.next.next = ListNode(4)
    l1 = create_list([2,4,3])
    l2 = create_list([5,6,4])

    node = addTwoNumbers(l1, l2)
    while(node != None):
        print(node.value)
        node = node.next
