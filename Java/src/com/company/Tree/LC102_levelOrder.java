package com.company.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> cur = new LinkedList<>();

            for(int i = 0; i < size; i++){
                TreeNode peek = q.poll();
                cur.add(peek.val);
                if(peek.left != null) q.offer(peek.left);
                if(peek.right != null) q.offer(peek.right);
            }
            res.add(cur);
        }
        return res;

    }
}
