package com.company.Tree;

public class LC90_recoverTree {
    TreeNode past_node;
    // two nodes to be swap
    TreeNode first_node;
    TreeNode second_node;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first_node.val;
        first_node.val = second_node.val;
        second_node.val = temp;
    }

    private void inorder(TreeNode node){
        if (node != null){
            inorder(node.left);
            if(past_node != null && node.val <= past_node.val && first_node == null) first_node = past_node;
            if(past_node != null && node.val <= past_node.val && first_node != null) second_node = node;
            past_node = node;
            inorder(node.right);
        }
    }
}
