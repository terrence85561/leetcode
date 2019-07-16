package com.company.Graph;


import java.util.*;

public class LC207_canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        /*
            BFS + Topological sort
            iterative
         */

        int size = prerequisites.length;
        if(size == 0) return true;

        int[] indegree = new int[numCourses];
        List<Integer>[] mapping = new ArrayList[numCourses];
        // HashMap<Integer, List<Integer>> mapping = new HashMap<>();

        // get indegree for each node
        // map each node with its adjacent nodes
        for(int i = 0; i < size; i++){
            indegree[prerequisites[i][0]]++;
            if(mapping[prerequisites[i][1]] != null){
                mapping[prerequisites[i][1]].add(prerequisites[i][0]);
            }else{
                List<Integer> adj_arr = new ArrayList<>();
                adj_arr.add(prerequisites[i][0]);
                mapping[prerequisites[i][1]] =  adj_arr;
            }

        }

        Queue<Integer> queue = new LinkedList<>();
        int numValidCourse = 0;

        // push zero indegree node into queue
        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0) queue.offer(i);
        }

        // bfs
        while(!queue.isEmpty()){
            int peek = queue.poll();
            numValidCourse++;


            List<Integer> adj = mapping[peek];
            if(adj != null){
                for(Integer i : adj){
                    indegree[i]--;
                    if(indegree[i] == 0) queue.offer(i);
                }
            }

        }

        if(numValidCourse == numCourses) return true;
        else return false;
    }



    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1,0},{0,1},{1,2}};
        LC207_canFinish L = new LC207_canFinish();
        System.out.println(L.canFinish(numCourses, prerequisites));
    }
}
