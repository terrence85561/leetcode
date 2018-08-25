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

    def HasPathSum(self,root,sum):
        '''
        dfs w/o recursion
        '''
        if root is None:
            return False
        stack = [(root,sum)]
        while stack:
            node,val = stack.pop()
            if node:
                if not node.left and not node.right and node.val == val:
                    return True

                stack.append((node.right,val - node.val))
                stack.append((node.left,val - node.val))


        return False


    def HasPathSum1(self,root,sum):
        '''
        dfs w/o recursion
        another version
        '''
        if root is None:
            return False

        stack = [(root,root.val)]
        while stack:
            node,val = stack.pop()
            if node:
                if node.left == None and node.right == None:
                    if val == sum:
                        return True
                if node.left:
                    stack.append((node.left,val + node.left.val))
                if node.right:
                    stack.append((node.right,val + node.right.val))
        return False
