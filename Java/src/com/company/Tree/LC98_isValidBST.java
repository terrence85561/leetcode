package com.company.Tree;

public class LC98_isValidBST {
    boolean isValid = true;
    TreeNode past_node;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return isValid;
        TreeNode cur_node = root;
        inorder(cur_node);
        return isValid;
    }

    private void inorder(TreeNode node){
        if(node != null){
            inorder(node.left);
            if(past_node != null && node.val <= past_node.val){
                isValid = false;
            }else{
                past_node = node;
            }
            inorder(node.right);
        }

    }
}
