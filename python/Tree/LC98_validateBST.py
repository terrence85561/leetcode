# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:

    # recursion 
    # O(n) time O(n) space
    # 首先假设 lower bound = -inf, upper bound = +inf
    # 但是这种情况下，无法将边界为[-inf, +inf]的bst的情况囊括
    # 所以将lowerbound改成none， upper bound也改成none


    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, None, None)

    def helper(self, root, lo, hi):
        if not root:
            return True
        #注意 不能写成if lo and root.val <= lo， 因为当lo = 0时， boolean(lo) == False
        if lo != None and root.val <= lo:
            return False
        if hi != None and root.val >= hi:
            return False

        if not self.helper(root.left, lo, root.val):
            return False
        if not self.helper(root.right, root.val, hi):
            return False
        return True


class Solution:
    last_node = None
    isValid = True

    def isValidBST(self, root: TreeNode) -> bool:
        self.inOrder(root)
        return self.isValid

    def inOrder(self, root):
        if not root:
            return
        self.inOrder(root.left)
        if self.last_node and self.last_node.val >= root.val:
            self.isValid = False
        self.last_node = root
        self.inOrder(root.right)


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
            # return True

        if not root.left and not root.right:
            return True
        curNode = root
        self.traverse(curNode)
        return self.isValid
