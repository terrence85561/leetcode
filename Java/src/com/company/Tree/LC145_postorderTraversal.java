package com.company.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        /*
            use 2 stacks
         */
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode top = s1.pop();
            s2.push(top);
            if(top.left != null){
                s1.push(top.left);
            }
            if(top.right != null){
                s1.push(top.right);
            }
        }

        while(!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        return res;
    }
}
