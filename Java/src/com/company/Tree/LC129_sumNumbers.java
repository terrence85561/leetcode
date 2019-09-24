package com.company.Tree;

public class LC129_sumNumbers {
    int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        if(root == null) return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int cur){
        cur = cur * 10 + node.val;
        if(node.left == null && node.right == null){
            res += cur;
            return;
        }
        if(node.left != null) dfs(node.left, cur);
        if(node.right != null) dfs(node.right, cur);
    }
}
