# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        leetcode226
        """
        if root:
            left = self.invertTree(root.left)
            right = self.invertTree(root.right)
            root.left = right
            root.right = left
            return root

        # if root:
        #     root.left,root.right = root.right,root.left
        #     self.invertTree(root.left)
        #     self.invertTree(root.right)
        #     return root
