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

    def invertTreeBFS(self.root):
        
        queue = []
        queue.append(root)
        while queue:
            node = queue.pop(0)

            if node:
                node.left,node.right = node.right,node.left
                queue.append(node.left)
                queue.append(node.right)
        return root
