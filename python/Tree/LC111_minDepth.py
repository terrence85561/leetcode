# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        #dfs
        # if not root:
        #     return 0
        # if not root.left:
        #     return self.minDepth(root.right)+1
        # if not root.right:
        #     return self.minDepth(root.left)+1
        # return min(self.minDepth(root.right), self.minDepth(root.left))+1
       
        #bfs
        if not root:
            return 0
        d = 1
        most_right = root
        q = [root]
        while(len(q) != 0):
            node = q.pop(0)
            if not node.left and not node.right:
                break
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
            
            if(node == most_right):
                d+=1
                if node.right:
                    most_right = node.right
                else:
                    most_right = node.left
                    
        return d
        