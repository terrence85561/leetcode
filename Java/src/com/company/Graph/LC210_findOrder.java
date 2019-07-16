package com.company.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210_findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] res = new int[numCourses];
        int res_size = 0;

        int[] indegree = new int[numCourses];
        List<Integer>[] mapping = new ArrayList[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            if(mapping[prerequisites[i][1]] != null){
                mapping[prerequisites[i][1]].add(prerequisites[i][0]);
            }else{
                List<Integer> adj_arr = new ArrayList<>();
                adj_arr.add(prerequisites[i][0]);
                mapping[prerequisites[i][1]] = adj_arr;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }


        int cntCourses = 0;
        while(!queue.isEmpty()){
            int peek = queue.poll();
            res[res_size++] = peek;
            cntCourses++;

            List<Integer> adj = mapping[peek];
            if(adj != null){
                for(Integer i : adj){
                    indegree[i]--;
                    if(indegree[i] == 0) queue.offer(i);
                }
            }
        }

        if(cntCourses == numCourses) return res;
        else return new int[]{};
    }
}
