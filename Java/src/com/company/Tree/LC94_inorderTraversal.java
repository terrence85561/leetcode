package com.company.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
    required using iterative method, rather than recursive method.
 */
public class LC94_inorderTraversal {
    /*
        but recursive anyway
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorder(res, root);
//        return res;
//    }
//
//    private void inorder(List<Integer> res, TreeNode root){
//        if(root != null){
//            inorder(res, root.left);
//            res.add(root.val);
//            inorder(res, root.right);
//        }
//        return;
//    }

    /*
        iteration method
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> temp = new Stack<>();

        TreeNode node = root;

        while(node != null || !temp.isEmpty()){
            if(node != null){
                temp.push(node);
                node = node.left;
            }else{
                TreeNode lastNode = temp.pop();
                res.add(lastNode.val);
                node = lastNode.right;
            }
        }

        return res;
    }
}
