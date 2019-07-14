package com.company.Tree;

public class LC1028_recoverFromPreorder {
    /*
       cnt is a global variable for counting the index of String S we are working on.

     */
    int cnt = 0;
    public TreeNode recoverFromPreorder(String S) {
        if(S == null || S.length() == 0) return null;
        return recover_tree(S, 0);
    }

    private TreeNode recover_tree(String S, int depth){
        /*
            depth is the expected depth of tree we are working on.
         */

        // get number of dashes
        // 1-2--3
        int d = 0;
        while(cnt < S.length() && S.charAt(cnt)=='-'){
            cnt++;
            d++;
        }
        if(d != depth){
            // if the number of dashes (the correct depth) is not as same as expected depth
            // go back and return null
            cnt -= d;
            return null;
        }

        int val = 0;
        while(cnt < S.length() && S.charAt(cnt) != '-'){
            val = val*10 + S.charAt(cnt) - '0';
            cnt++;
        }

        TreeNode node = new TreeNode(val);
        node.left = recover_tree(S, depth+1);
        node.right = recover_tree(S, depth+1);
        return node;

    }
}
