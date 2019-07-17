# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        leetcode 101
        recursion version DFS
        """

        if not root:
            return True
        return self.isSym(root.left,root.right)

    def isSym(self,left,right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        if left.val == right.val:
            return self.isSym(left.right,right.left) and self.isSym(left.left,right.right)
        else:
            return False

    def isSymmetricIte(self,root):
        """
        iterative version
        """
        
