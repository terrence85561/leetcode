# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        # should be in O(h), which means we should only go to one of the children
        # case 1: delete leaf, return None
        # case 2: delete a node with only left child, return left child
        # case 3: delete a node with only right child, return right child
        # case 4: delete a node with both left and right child, swap with the smallest node in right subtree, and delete the key node's reference.
        
        if not root:
            return None
        
        if root.val < key:
            root.right = self.deleteNode(root.right, key)
        elif root.val > key:
            root.left = self.deleteNode(root.left, key)
        else:
            # case 1
            if not root.left and not root.right:
                return None
            # case 2
            elif not root.right:
                return root.left
            # case 3
            elif not root.left:
                return root.right
            # case 4
            else:
                parent = root
                minNode = root.right
                while(minNode.left):
                    parent = minNode
                    minNode = minNode.left
                
                if(parent != root):
                    parent.left = minNode.right
                    minNode.right = root.right
                
                minNode.left = root.left
                del root
                
                return minNode
            
        return root
                
        