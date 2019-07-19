package com.company.Tree;

public class LC222_countNodes {
    private int tree_depth = 0;
    private int res = 0;
    public int countNodes(TreeNode root) {

        if(root == null) return 0;

        TreeNode node = root;
        while(node.left != null){
            tree_depth ++;
            node = node.left;
        }

        res += (1 << tree_depth) - 1  ;

        dfs(root, 0);

        return res;
    }

    private void dfs(TreeNode root, int start_depth){

        if(root.left == null){
            if(start_depth == tree_depth){
                res+=1;
            }
            return;
        }
        if(root.right == null){
            res+=1;
            return;
        }

        TreeNode temp = root.right;
        int cur_depth = start_depth + 1;

        while(temp.left != null){
            cur_depth ++ ;
            temp = temp.left;
        }

        if(cur_depth == tree_depth){
            res += 1 << (tree_depth - start_depth - 1 );
            dfs(root.right, start_depth + 1);
        }else{
            dfs(root.left, start_depth + 1);

        }
    }
}
