class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
            # bottom up, O(n) time

        def getHeight(root):
            if not root:
                return True, -1
            leftisbalance, leftheight = getHeight(root.left)
            if not leftisbalance:
                return False, 0
            rightisbalance, rightheight = getHeight(root.right)
            if not rightisbalance:
                return False, 0
            return abs(rightheight-leftheight) <= 1, 1+max(rightheight, leftheight)
        return getHeight(root)[0]
        
    def isBalanced(self, root: TreeNode) -> bool:
        #         O(n^2) recalculated the maxDepthh of each node
        # top-down
        # if not root:
        #     return True
        # # Height of a node - No. of edges on longest path from that node to the farthest leaf.

        # # Depth - No. of edges on the path from that node to the root.

        # # Height of tree is, Height of ROOT.

        # # Depth of tree is, maximum depth in the tree.
        # def getHeight(root):
        #     if not root:
        #         return -1
        #     return 1+max(getHeight(root.left), getHeight(root.right))
        # left = getHeight(root.left)
        # right = getHeight(root.right)
        # return abs(left-right) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right)



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
