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
        self.res = True #global var
        def maxDepth(root):
            if root is None:
                return 0
            left = maxDepth(root.left)
            right = maxDepth(root.right)
            if abs(left-right)>1:
                self.res = False
            return max(left,right)+1
        maxDepth(root)
        return self.res
