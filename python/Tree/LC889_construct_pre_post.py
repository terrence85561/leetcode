class Solution:
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> TreeNode:
        post_len = len(post)
        if post_len == 0:
            return None
        root = TreeNode(post[-1])
        if post_len == 1:
            return root

        left_subtree_root_index = post.index(pre[1])

        root.left = self.constructFromPrePost(
            pre[1:left_subtree_root_index+2], post[0:left_subtree_root_index+1])
        root.right = self.constructFromPrePost(
            pre[left_subtree_root_index+2:], post[left_subtree_root_index+1:len(post)-1])

        return root
