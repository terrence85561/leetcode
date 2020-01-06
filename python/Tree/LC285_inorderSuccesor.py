class Solution:
    def inorderSuccessor(self, root: 'TreeNode', p: 'TreeNode') -> 'TreeNode':
        res = None
        while(root != None):
            if(root.val <= p.val):
                root = root.right
            else:
                res = root
                root = root.left
        return res
