package com.company.Tree;

public class LC687_longestUnivaluePath {

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left_length = dfs(root.left);
        int right_length = dfs(root.right);

        int l = 0, r = 0;

        if(root.left != null && root.val == root.left.val){
            l = 1 + left_length;
        }
        if(root.right != null && root.val == root.right.val){
            r = 1 + right_length;
        }

        max = Math.max(max, l + r);


        return Math.max(l, r);
    }

}
