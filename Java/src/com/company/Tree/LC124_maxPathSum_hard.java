package com.company.Tree;

public class LC124_maxPathSum_hard {
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return maxPath;
    }


    // return the longest path for node to its right subtree or left subtree
    private int dfs(TreeNode node){
        if(node == null) return 0;
        int left = (node.left == null) ? 0 : Math.max(dfs(node.left), 0);
        int right = (node.right == null) ? 0 : Math.max(dfs(node.right), 0);

        maxPath = Math.max(maxPath, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
