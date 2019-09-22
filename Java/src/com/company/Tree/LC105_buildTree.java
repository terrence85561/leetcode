package com.company.Tree;

public class LC105_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pre_st, int in_st, int in_end){
        if(pre_st >= preorder.length || in_st > in_end) return null;
        TreeNode node = new TreeNode(preorder[pre_st]);
        int index = 0;
        while(index <= in_end && inorder[index] != preorder[pre_st]){
            index++;
        }

        node.left = buildTree(preorder, inorder, pre_st+1, in_st, index-1);
        node.right = buildTree(preorder, inorder, pre_st+index-in_st+1, index+1, in_end);
        return node;
    }
}
