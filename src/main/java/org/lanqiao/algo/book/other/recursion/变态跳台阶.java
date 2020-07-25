package org.lanqiao.algo.book.other.recursion;

import java.util.HashMap;
import java.util.Map;

// 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class 变态跳台阶 {
	public static Map<Integer, Integer> hash=new HashMap<Integer, Integer>();
	 public static int numWays(int n) {
		 //我们利用递归回溯思想先找边界
	        if(n==2) {
	        	return 2;
	        }else if (n<=1) {
				return 1;
			}else {
				if (!hash.containsKey(n-2)) {
					hash.put(n-2, numWays(n-2));
				}
				if (!hash.containsKey(n-1)) {
					hash.put(n-1,numWays(n-1) );
				}
				return (hash.get(n-2)+hash.get(n-1))%1000000007;
			}
	    }
	 public static void main(String[] args) {
		 System.out.println(numWays(44));
	 }
}
