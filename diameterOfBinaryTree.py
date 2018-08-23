# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        leetcode 543
        """
        if root is None:
            return 0
        depth =  self._maxDepth(root.left)+self._maxDepth(root.right)
        return max(max(depth,self.diameterOfBinaryTree(root.left)),self.diameterOfBinaryTree(root.right))
    def _maxDepth(self,root):
        if root is None:
            return 0
        return max(self._maxDepth(root.left),self._maxDepth(root.right)) + 1
