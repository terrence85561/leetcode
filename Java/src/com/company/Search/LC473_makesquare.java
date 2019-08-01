package com.company.Search;

import java.util.Arrays;

public class LC473_makesquare {
    public boolean makesquare(int[] nums) {
        /*
            算每条边应该的长度，来存状态
            https://www.youtube.com/watch?v=Z8cz4Wb5P2g
        */

        if(nums == null || nums.length == 0 || nums.length < 4) return false;
        int sum = 0;
        for(int i : nums){sum+=i;}

        if(sum % 4 != 0) return false;
        Arrays.sort(nums);
        return dfs(nums, 0, 1, sum / 4, 0, new boolean[nums.length] );

    }

    private boolean dfs(int[] nums, int start, int edge, int edge_size, int cur_sum, boolean[] visited){
        if(edge == 4) return true;
        if(cur_sum > edge_size) return false;
        if(cur_sum == edge_size){
            return dfs(nums, 0, edge + 1, edge_size, 0, visited);
        }
        for(int i = start; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            if(dfs(nums, start+1, edge, edge_size, cur_sum+nums[i], visited)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
