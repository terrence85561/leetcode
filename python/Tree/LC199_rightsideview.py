# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def dfs(self, root, view, level):
        if not root:
            return None
        if level > len(view):
            view.append(root.val)
        self.dfs(root.right, view, level+1)
        self.dfs(root.left, view, level+1)

    def rightSideView(self, root: TreeNode) -> List[int]:
        view = []
        self.dfs(root, view, 1)
        return view
