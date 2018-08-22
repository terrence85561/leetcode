# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        leetcode 104
        iterative with queue

        """

        if root is None:
            return 0

        queue = []
        queue.append(root)
        depth = 1
        leng = len(queue) # to record the node in one level
        while len(queue) > 0:
            if leng == 0:
                depth += 1
                leng = len(queue) # the rest nodes

            curr = queue.pop(0)
            leng -= 1 # in order to know whether the nodes in a certain level are traversed

            if curr.left is not None:
                queue.append(curr.left)
            if curr.right is not None:
                queue.append(curr.right)
        return depth
