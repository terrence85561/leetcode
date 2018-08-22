# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:

    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        leetcode 110
        """
        self._result = True #private var
        self.maxDepth(root)

        return self._result

    def maxDepth(self,root):
        if root is None:
            return 0
        maxLeft = self.maxDepth(root.left)
        maxRight = self.maxDepth(root.right)
        if (abs(maxLeft - maxRight) > 1):

            self._result = False 


        return max(maxLeft,maxRight)+1
