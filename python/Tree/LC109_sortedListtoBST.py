# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    n = None

    def sortedListToBST(self, head: ListNode) -> TreeNode:
         # optimal O(2n) time O(logn) space for recursive tree
        # inorder traverse a bst will get asc sorted list
        global n
        n = head
        size = 0

        while(head):
            head = head.next
            size += 1
        return self.build(0, size-1)

    def build(self, start, end):
        global n
        if start > end:
            return None
        m = start + (end-start)//2
        left = self.build(start, m-1)
        parent_node = TreeNode(n.val)
        n = n.next
        parent_node.left = left
        right = self.build(m+1, end)
        parent_node.right = right
        return parent_node

        # O(2n) time O(n) space
    # def sortedListToBST(self, head: ListNode) -> TreeNode:

#         arr = []
#         while(head):
#             arr.append(head.val)
#             head = head.next
#         return self.build(arr, 0, len(arr)-1)

#     def build(self, arr, l, r):
#         if l>r:
#             return None
#         m = l+(r-l)//2
#         root = TreeNode(arr[m])
#         root.left = self.build(arr, l, m-1)
#         root.right = self.build(arr, m+1, r)
#         return root

        # O(nlogn) time O(logn) space for binary tree
    # def sortedListToBST(self, head: ListNode) -> TreeNode:

#         if not head:
#             return None
#         if not head.next:
#             return TreeNode(head.val)

#         prev = None
#         slow = head
#         fast = head
        # this step cost O(n/2)
#         while(fast and fast.next):
#             prev = slow
#             slow = slow.next
#             fast = fast.next.next
#         root = TreeNode(slow.val)

#         if prev:
#             prev.next = None

#         root.left = self.sortedListToBST(head)
#         root.right = self.sortedListToBST(slow.next)
#         return root
