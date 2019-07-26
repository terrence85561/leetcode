package com.company.Search;

import java.util.ArrayList;
import java.util.List;

public class LC113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        TreeNode node = root;

        dfs(node, res, cur, sum);
        return res;

    }
    private void dfs(TreeNode node, List<List<Integer>> res, List<Integer> cur, int sum){
        if(node == null) return;
        if(node.left == null && node.right == null){
            if(sum - node.val == 0){
                cur.add(node.val);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size()-1);
            }
            return;
        }
        sum = sum - node.val;
        cur.add(node.val);
        dfs(node.left, res, cur, sum);
        dfs(node.right, res, cur ,sum);
        cur.remove(cur.size()-1);

    }
}
