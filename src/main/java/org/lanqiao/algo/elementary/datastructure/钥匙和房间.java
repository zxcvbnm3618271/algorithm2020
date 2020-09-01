package org.lanqiao.algo.elementary.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 钥匙和房间 {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//使用list来记录能否打开房间,使用stack来进行访问房间
    boolean[] list=new boolean[rooms.size()];
    list[0]=true;
    int flag=1;
    Stack stack=new Stack();
    for (int s:rooms.get(0)) {
      stack.push(s);
    }
    while(!stack.empty()){
      int nowroom=(int)stack.pop();
      if (list[nowroom]==true)
        continue;
      list[nowroom]=true;
      for (int s:rooms.get(nowroom)) {
        stack.push(s);
      }
      flag+=1;
    }
    return flag==rooms.size();
  }
}
