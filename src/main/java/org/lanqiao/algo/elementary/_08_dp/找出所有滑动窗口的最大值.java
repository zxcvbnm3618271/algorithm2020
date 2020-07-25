package org.lanqiao.algo.elementary._08_dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 找出所有滑动窗口的最大值 {
	  public  ArrayList<Integer> maxInWindows(int[] num,int size){
	       ArrayList<Integer> record=new ArrayList<>();
	       //避免窗口大小为0
	       if(size==0){
	           return record;
	       }
			//记录每个最大值对应的下标
			Map<Integer, Integer> hash=new HashMap<Integer, Integer>();
			//slide记录跳过对比大小的跨度
			int i=0,max=-1,slide=size-1;
			hash.put(max, -1);
			while(i < num.length-slide)
			{
				//如果当前下标没有超过记录的最大值下标
				if (i<=hash.get(max)) {
					//当出现更大的值时更新max，否则直接跳过
						if (max<num[i+slide]) {
							max=num[i+slide];
							hash.put(max, i+slide);
						}
				//当超过最大值下标时需要找出最新的最大值下标
				}else {
					max=-1;
					for (int j = i; j < i+size; j++) {
						max=Math.max(max, num[j]);
	                    hash.put(num[j], j);
					}
				}
	            record.add(max);
				i++;
			}
			return record;
		}
}
