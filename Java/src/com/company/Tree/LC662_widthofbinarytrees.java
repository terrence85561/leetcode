package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

public class LC662_widthofbinarytrees {
    int max;

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> leftmost = new ArrayList<>();
        max = 1;
        dfs(root, 0, 1, leftmost);
        return max;
    }

    private void dfs(TreeNode node, int level, int position, List<Integer> leftmost){
        if(node == null) return;
        if(level >= leftmost.size()) leftmost.add(position);
        max = Math.max(max, position+1 - leftmost.get(level));
        dfs(node.left, level+1, position*2, leftmost);
        dfs(node.right, level+1, position*2+1, leftmost);
    }
}
