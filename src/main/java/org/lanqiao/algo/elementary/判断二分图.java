package org.lanqiao.algo.elementary;

import java.util.ArrayList;
import java.util.List;

public class 判断二分图 {
/**
 * 给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
使用三色标记+广度优先遍历
 */
public static boolean isBipartite(int[][] graph) {
  int[] color = new int[graph.length];    //0代表未访问，1与-1代表两种不同色
  for(int k = 0; k < graph.length; ++k){  //遍历各个连通分量
    if(color[k] != 0) continue;
    List<Integer> v = new ArrayList<>();    //广度优先队列
    v.add(k);
    color[k] = 1;
    while(!v.isEmpty()){    //遍历当前连通分量的所有节点
      int p = v.get(0);
      v.remove(0);
      for(int i = 0; i < graph[p].length; ++i){   //未染色的入队，已染色作比较
        if(color[graph[p][i]] != 0 && color[p] == color[graph[p][i]]) return false;
        else if(color[graph[p][i]] == 0){
          color[graph[p][i]] = -color[p];
          v.add(graph[p][i]);
        }
      }
    }
  }
  return true;    //遍历完各连通分量无异常，返回真
}
public static void main(String[] args){
  int[][] gragh={{1,3},{0,2},{1,3},{0,2}};
  isBipartite(gragh);

}
}
