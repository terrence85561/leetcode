# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        arr = []
        r_arr = []
        self.preorder(root, arr)
        self.r_preorder(root, r_arr)
        print(arr)
        print(r_arr)
        for i in range(len(arr)):
            if arr[i] != r_arr[i]:
                return False
        return True

    def preorder(self, root, arr):
        if not root:
            arr.append(-1)
            return
        arr.append(root.val)
        self.preorder(root.left, arr)
        self.preorder(root.right, arr)

    def r_preorder(self, root, arr):
        if not root:
            arr.append(-1)

            return
        arr.append(root.val)
        self.r_preorder(root.right, arr)
        self.r_preorder(root.left, arr)
