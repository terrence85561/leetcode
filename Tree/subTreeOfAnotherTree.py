class Solution:
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        leetcode 572
        
        """

        # 先遍历Tree s中的所有节点 然后对于每一个节点 比较它的subTree与Tree t是否一样

        #Edge case
        if not s:
            return False
        if self.isSame(s,t):
            return True
        return self.isSubtree(s.left,t) or self.isSubtree(s.right,t)

    def isSame(self,s,t):
        if not s and not t:
            return True
        if not s or not t:
            return False
        return s.val == t.val and self.isSame(s.left,t.left) and self.isSame(s.right,t.right)
