package org.lanqiao.algo.elementary.digit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
//利用priorityqueue构建出一个由每个数组提供的一个元素构成的小顶堆
//用数组记录每一个数组对应的指针
//小顶堆能保证我们每次都能拿到区间的最小值.
public class 最小区间 {
	    public static int[] smallestRange(List<List<Integer>> nums) {
	        int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	        //记录数组数n
	        int n = nums.size();
	        //记录每个数组对应的指针值	        
	        int[] p = new int[n];
	        //这里是算法的关键,小顶堆比较规则改为第a行指针a所指列与第b行指针b所指列进行比较	   
	        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->(nums.get(a).get(p[a]) - nums.get(b).get(p[b])));
	        //将每个数组第一个数推入小顶堆
	        for (int i = 0; i < n; i ++)
	        {
	            heap.offer(i);
	            max = Math.max(nums.get(i).get(0), max);
	        }

	        while(true)
	        {
//	        	获取当前区间最小的值所属的行
	            int x = heap.poll();
//	            当找到更小的区间时,进行区间替换
	            if (miny - minx > max - nums.get(x).get(p[x]))
	            {
	                minx = nums.get(x).get(p[x]);
	                miny = max;
	            }
//	            指针移到下一位
	            p[x] ++;
	            //如果当前数组的指针大于等于数组长度就结束
	            if (p[x] >= nums.get(x).size()) break;
	            heap.offer(x);
	            
	            max = Math.max(max, nums.get(x).get(p[x]));
	        }
	        return new int[]{minx, miny};
	    }
	public static void main(String[] args) {
		List<List<Integer>> nums= new ArrayList<List<Integer>>();
		nums.add(new ArrayList<>());
		int[] a=smallestRange(nums);
	}


}
