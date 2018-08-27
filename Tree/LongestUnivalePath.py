
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        687. Longest Univalue Path
        """
        #Edge case
        if not root:
            return 0
        #process
        def helper(root):
            count = 0

            if not root:
                return 0
            if root.left and root.left.val == root.val:
                count += 1
                count += helper(root.left)
            if root.right and root.right.val == root.val:
                count += 1
                count += helper(root.right)
            return count


        #recursion
        return max(max(helper(root),self.longestUnivaluePath(root.left)), self.longestUnivaluePath(root.right))
