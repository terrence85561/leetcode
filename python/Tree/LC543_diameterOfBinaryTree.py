class Solution:
    res = 0

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.find_max(root)
        return self.res

    def find_max(self, root):
        # find the max path from root of the tree
        # and update the max path to global res
        if not root:
            return 0
        left = self.find_max(root.left)
        right = self.find_max(root.right)
        self.res = max(self.res, right+left)
        return max(right, left)+1
