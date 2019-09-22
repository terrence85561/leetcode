package com.company.Tree;

public class LC106_buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int post_st, int in_st, int in_end){
        if(post_st < 0 || in_st > in_end) return null;
        TreeNode node = new TreeNode(postorder[post_st]);
        int index = 0;
        while(inorder[index] != postorder[post_st]){
            index++;
        }
        node.right = buildTree(inorder, postorder, post_st-1, index+1, in_end );
        node.left = buildTree(inorder, postorder, post_st - (in_end - index + 1), in_st, index-1);
        return node;
    }
}
