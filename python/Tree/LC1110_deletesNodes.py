# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        td = set(to_delete)
        rtn = []
        root = self.helper(root, rtn, td)
        if root:
            rtn.append(root)
        return rtn

    def helper(self, root, rtn, td):
        if not root:
            return None
        root.left = self.helper(root.left, rtn, td)
        root.right = self.helper(root.right, rtn, td)
        if root.val in td:
            if root.left:
                rtn.append(root.left)
            if root.right:
                rtn.append(root.right)
            return None
        else:
            return root
