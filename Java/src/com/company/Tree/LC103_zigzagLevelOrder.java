package com.company.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        int cnt = 0;
        while(!stack.isEmpty()){
            int size = stack.size();
            List<Integer> cur = new LinkedList<>();

            Stack<TreeNode> next = new Stack<>();
            for(int i = 0; i < size; i++){
                TreeNode peek = stack.pop();
                cur.add(peek.val);
                if(cnt % 2 != 0){
                    if(peek.right != null){
                        next.push(peek.right);
                    }
                    if(peek.left != null){
                        next.push(peek.left);
                    }
                }else{
                    if(peek.left != null){
                        next.push(peek.left);
                    }
                    if(peek.right != null){
                        next.push(peek.right);
                    }
                }

            }
            cnt++;
            res.add(cur);
            stack = next;
            next = null;
        }
        return res;
    }
}
