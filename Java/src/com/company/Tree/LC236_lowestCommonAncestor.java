package com.company.Tree;

public class LC236_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if(leftLCA != null && rightLCA != null) return root;
        else{
            if(leftLCA == null) return rightLCA;
            if(rightLCA == null) return leftLCA;
            else return null;
        }
    }
}
