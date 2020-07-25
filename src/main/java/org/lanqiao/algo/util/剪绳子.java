package org.lanqiao.algo.util;

public class 剪绳子 {
	public static int cutRope(int target) {

		double d=Double.valueOf(String.valueOf(target));
		int m=(int)Math.ceil(Math.sqrt(d));
		int n=0;
		int max=0;
		while(target-m>0) {
			target-=m;
			n++;
		}
		max=(int)Math.pow(m, n)*target;
		return max;
	}
	public static void main(String[] args) {
		System.out.println(cutRope(8));
	}

}
