package org.lanqiao.algo.elementary._07_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//       记录入度
        int[] indegrees=new int[numCourses];
//        记录出度
        List<List<Integer>> adjacency=new ArrayList<>();
//        记录删除节点的队列
        Queue<Integer> queue = new LinkedList<>();
//        初始化出度数组
        for (int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
//        写入入度和出度
        for (int[] cp:prerequisites){
//            节点cp[0]的入度+1
            indegrees[cp[0]]++;
//            记录节点cp[0]的出度有哪些
            adjacency.get(cp[1]).add(cp[0]);
        }
//        找出入度为0的节点,推入删除队列
        for (int i=0;i<numCourses;i++)
            if (indegrees[i]==0) queue.add(i);
//            根据删除队列清楚入度为0的节点
            while (!queue.isEmpty()){
                int pre=queue.poll();
                numCourses--;
                for (int cur:adjacency.get(pre))
                    if (--indegrees[cur]==0) queue.add(cur);
            }
            return numCourses==0;
    }
}
