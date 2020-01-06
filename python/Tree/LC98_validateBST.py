# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    # def traverse(self, root, inorder):
    #     if not root:
    #         return
    #     self.traverse(root.left, inorder)
    #     inorder.append(root.val)
    #     self.traverse(root.right, inorder)

    isValid = True
    last_node = None

    def traverse(self, node):
        if node:
            self.traverse(node.left)
            if self.last_node and self.last_node.val >= node.val:
                self.isValid = False
            else:
                self.last_node = node
            self.traverse(node.right)

    def isValidBST(self, root: TreeNode) -> bool:
        # inorder = []
        # self.traverse(root, inorder)
        # for i in range(len(inorder)):
        #     if(i >= 1 and inorder[i] <= inorder[i-1]):
        #         return False
        # return Truea        if not root:
            return True

        if not root.left and not root.right:
            return True
        curNode = root
        self.traverse(curNode)
        return self.isValid
