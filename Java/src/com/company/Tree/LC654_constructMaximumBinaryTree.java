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


    /*

     */
    public TreeNode constructMaximumBinaryTreeFaster(int[] nums) {
        int size = nums.length;
        if(size == 0) return null;
        else if(size == 1) return new TreeNode(nums[0]);

        return dfs(nums, 0 , size - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end){
        if(start > end) return null;
        int max_idx = start;
        int max = nums[max_idx];
        for(int i = start + 1; i <= end; i++){
            if(nums[i] > max){
                max_idx = i;
                max = nums[i];
            }
        }
        TreeNode maxNode = new TreeNode(max);
        maxNode.left = dfs(nums, start, max_idx - 1);
        maxNode.right = dfs(nums, max_idx + 1, end);
        return maxNode;

    }
}
