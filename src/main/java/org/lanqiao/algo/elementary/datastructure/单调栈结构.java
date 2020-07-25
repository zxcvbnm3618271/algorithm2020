package org.lanqiao.algo.elementary.datastructure;

import java.util.Scanner;


public class 单调栈结构 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner =new Scanner(System.in);
long n=scanner.nextLong();
long l=0,r=0;
long[] nums=new long[(int)n]; 
for (int i = 0; i < n; i++) {
	nums[i]=scanner.nextLong();
}
	for (int i = 0; i < n; i++) {
		l=i-1;
		r=i+1;
		while(l>=0&&nums[(int)l]>nums[i]) {
			l--;
		}
		if (l<0) {
			System.out.print("-1 ");
		}else {
			System.out.print(l+" ");
		}
		while(r<n&&nums[(int)r]>nums[i]) {
			r++;
		}
		if (r>=n) {
			System.out.println("-1");
		}else {
			System.out.println(r);
		}
	}
	}

}
