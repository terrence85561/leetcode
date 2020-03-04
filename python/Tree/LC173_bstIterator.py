# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class BSTIterator:
    def __init__(self, root: TreeNode):
        # from collections import deque
        # self.queue = deque()
        # list.pop(0) takes O(n), list.pop() takes O(1)
        self.stack = []
        self.inOrder(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        if self.hasNext():
            return self.stack.pop()

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if len(self.stack) == 0:
            return False
        else:
            return True

    def inOrder(self, root):
        if not root:
            return
        # reverse inorder travese

        self.inOrder(root.right)
        self.stack.append(root.val)
        self.inOrder(root.left)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
