class Solution:
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        leetcode617
        """
        if t1 is None:
            return t2
        if t2 is None:
            return t1
        node = TreeNode(t1.val+t2.val)
        node.left = self.mergeTrees(t1.left,t2.left)
        node.right = self.mergeTrees(t1.right,t2.right)
        return node
