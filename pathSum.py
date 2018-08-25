# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        leetcode 112
        """
        if root is None:
            return False

        if root.left == None and root.right == None:
            return root.val == sum

        left = self.hasPathSum(root.left,sum - root.val)
        right = self.hasPathSum(root.right,sum - root.val)
        return left or right

    def HasPathSum(self.root,sum):
        '''
        dfs w/o recursion
        '''
