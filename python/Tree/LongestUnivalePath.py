
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
        # define output value
        self.res = 0

        #define a helper function: for each node, return the longestUnivaluePath when the node is root
        def helper(root):
            #edge case:
            if not root:
                return 0
            #process:
            #left,right get the longestUP from left node and right node
            left = helper(root.left)
            right = helper(root.right)

            #define variable to store the length of UP
            Lcount = 0
            Rcount = 0

            #if the root of left/right subtree is equal to the current node
            if root.left and root.left.val == root.val:
                Lcount = left + 1
            if root.right and root.right.val == root.val:
                Rcount = right + 1

            #update the output value
            self.res = max(self.res,Lcount+Rcount)

            # return the longest univalue path between left&right subtree
            # Since we need to get the longest one to connect with the parent node
            return max(Lcount,Rcount)

        helper(root)

        return self.res
