package org.lanqiao.algo.elementary._07_dfs;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;


public class 重新安排行程 {

//  以当前的地方为键,能去的地方为值
  Map<String, PriorityQueue<String>> map=new HashMap<String,PriorityQueue<String>>();
//  存出结果
  List<String> itinerary =new LinkedList<String>();

public List<String> findItinerary(List<List<String>> tickets){
  if (tickets==null||tickets.size()<=0){
    return null;
  }
//  出发地
  String src=null;
//  目的地
  String target = null;
  for (List<String> ticket:tickets) {
    src = ticket.get(0);
    target = ticket.get(1);
    if (!map.containsKey(src)){
      map.put(src,new PriorityQueue<String>());
    }
    map.get(src).offer(target);
  }
  dfs("JFK");
  Collections.reverse(itinerary);
  return itinerary;
}

private void dfs(String cur){
//  当cur不是任何一张票的起点,或者目的地在之前都去过了就结束深度遍历
  while (map.containsKey(cur)&&map.get(cur).size()>0){
    String tmp = map.get(cur).poll();
    dfs(tmp);
  }
  itinerary.add(cur); // 将 只能作为 “最终目的地” 的地点先录入(由此得到的 itinerary 是由 终点 指向 起点 的)
}

}
