class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        #         O(n^2) recalculated the maxDepthh of each node
        #         if not root:
        #             return True
        #         leftDepth = self.maxDepth(root.left)
        #         rightDepth = self.maxDepth(root.right)
        #         if abs(leftDepth-rightDepth) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right):
        #             return True
        #         else:
        #             return False

        #     def maxDepth(self, root):
        #         if not root:
        #             return 0
        #         return max(self.maxDepth(root.left), self.maxDepth(root.right))+1

        #       O(n)
        return self.maxDepth(root) != -1

    def maxDepth(self, node):
        if node == None:
            return 0
        leftDepth = self.maxDepth(node.left)
        if leftDepth == -1:
            return -1
        rightDepth = self.maxDepth(node.right)
        if rightDepth == -1:
            return -1
        if abs(leftDepth-rightDepth) <= 1:
            return max(leftDepth, rightDepth) + 1
        else:
            return -1
