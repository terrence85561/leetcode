# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        leetcode: 437
        """
        #edge case:
        if root is None:
            return 0
        #process:
        def dfs(root,sum):
            count = 0
            if root is None:
                return 0
            if root.val == sum:
                count += 1
            count += dfs(root.left,sum - root.val)
            count += dfs(root.right,sum - root.val)

            return count

        #recursion:
        return dfs(root,sum) + self.pathSum(root.left,sum) + self.pathSum(root.right,sum)
