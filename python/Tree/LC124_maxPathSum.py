# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.maxSum = float('-inf')
        self.findMax(root)
        return self.maxSum

    def findMax(self, node):
        # for a certain node, there are 4 cases:
        # 1. maxPathSum(node.left) + node.val
        # 2. maxPathSum(node.right) + node.val
        # 3. maxPathSum(node.right) + maxPathSum(node.left) + node.val
        # 4. node.val
        if not node:
            return 0
        left_max = self.findMax(node.left)
        if left_max < 0:
            left_max = 0
        right_max = self.findMax(node.right)
        if right_max < 0:
            right_max = 0
        # update maxSum value
        self.maxSum = max(self.maxSum, left_max+right_max+node.val)
        # return the larger sum of a path goes to left or goes to right subtree
        # return this result to the upper level to continously compute the maxSum
        return node.val + max(left_max, right_max)


class Solution:
    # 简化问题，如果不考虑是path，只考虑左子树的最大和 + 右子树最大和 + 现节点值， 那么站在某节点上， 只需递归求左子树最大值+右子树最大值+现节点值即可
    # 考虑path，那么站在某节点上，首先需要考虑是走左子树还是右子树。解决这个问题，只需递归求max(左子树和最大的path， 右子树和最大的path)+现节点值即可
    # 但是这样只能求得过根节点的和最大的path
    # 所以要用一个global变量来存maxPathSum
    # 
    # debug发现，若子树返回的和最大的path为负数怎么办
    # 把这个path的最大和当做是0，意思是不考虑这条path了
    
    def maxPathSum(self, root: TreeNode) -> int:
        maxSum = [float('-inf')]

        def findMax(node, maxSum):
            if not node:
                return 0
            left = findMax(node.left, maxSum)
            if left < 0:
                left = 0
            right = findMax(node.right, maxSum)
            if right < 0:
                right = 0
            maxSum[0] = max(left+right+node.val, maxSum[0])
            return node.val+max(left, right)
        findMax(root, maxSum)
        return maxSum[0]
