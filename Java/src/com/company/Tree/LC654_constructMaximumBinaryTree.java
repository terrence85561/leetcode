package com.company.Tree;

import java.util.Arrays;

public class LC654_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int size = nums.length;
        // base case
        if(size == 0 || nums == null) return null;

        int max = Integer.MIN_VALUE;
        int max_idx = 0;
        for(int i = 0; i < size; i++){
            if(nums[i] > max) {
                max = nums[i];
                max_idx = i;
            }
        }

        TreeNode maxNode = new TreeNode(max);
        maxNode.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, max_idx));
        maxNode.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, max_idx + 1, size));

        return maxNode;
    }
}
