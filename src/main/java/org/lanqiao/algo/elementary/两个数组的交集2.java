package org.lanqiao.algo.elementary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定两个数组，编写一个函数来计算它们的交集。
 */
public class 两个数组的交集2 {
  public static int[] intersect_3(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>(nums1.length);
    // 将 nums1 出现的数值及频次放入映射中
    for (int num : nums1) {
      Integer count = map.get(num);
      if (count == null) {
        map.put(num, 1);
      } else {
        map.put(num, ++count);
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int num : nums2) {
      // 获取映射中该数值出现的频次
      Integer count = map.get(num);
      if (count != null && count != 0) {
        list.add(num);
        // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
        map.put(num, --count);
      }
    }
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
  }
public static void main(String[] args){
  int[] num1={4,9,4,9};
  int[] num2={9,4,9,4,10};
  int[] num=intersect_3(num1,num2);
}
}
