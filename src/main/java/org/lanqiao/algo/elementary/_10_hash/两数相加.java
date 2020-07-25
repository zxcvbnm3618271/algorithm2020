package org.lanqiao.algo.elementary._10_hash;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class 两数相加 {
/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
假设给出的数组中只存在唯一解
例如：
给出的数组为 {2, 7, 11, 15},目标值为9
输出 ndex1=1, index2=2
 * @param args
 */
	 public int[] twoSum (int[] numbers, int target) {
	        // write code here
	        //利用双指针：头指针和尾指针
	        //利用哈希记录未排序前的下标
	        //先对数组进行排序，快排O（nlogn）
		 //因为有重复值，因此用队列来存value
	        HashMap<Integer, Deque<Integer>> hashMap=new HashMap<>();
	        int i=0;
	        for(int t:numbers){
	        	if (!hashMap.containsKey(t)) {
					Deque<Integer> deque=new ArrayDeque<Integer>();
					deque.add(i++);
					hashMap.put(t, deque);
				}else {
					hashMap.get(t).add(i++);
				}
	        }
	        //对数组的值进行排序
	        Arrays.sort(numbers);
	        int[] pivot=new int[2];
	        int start=0;
	        int end=numbers.length-1;
	        int sum=numbers[start]+numbers[end];
	        //通过头尾指针找合适的数
	        while(sum!=target&&start<end){
	            if(sum>target){
	                end--;
	            }else{
	                start++;
	            }
	            sum=numbers[start]+ numbers[end];
	        }
	        if(sum==target){
	            pivot[0]=hashMap.get(numbers[start]).pollFirst()+1;
	            pivot[1]=hashMap.get(numbers[end]).pollFirst()+1;
	            //头指针对应的值在原数组中可能会在尾指针对应值右侧，比如【5，75，25】
	            //因此需要在排序O（2lg2）
	            Arrays.sort(pivot);
	        }
	        return pivot;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
