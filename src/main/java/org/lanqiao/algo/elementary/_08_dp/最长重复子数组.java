package org.lanqiao.algo.elementary._08_dp;
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
public class 最长重复子数组 {

	//使用动态规划思想
	 public int findLength(int[] A, int[] B) {
		 int max=0;
		 int[] dp=new int[B.length+1];
		
		 for (int i = 1; i <=A.length; i++) {
			for (int j = B.length; j>0; j--) {
				if (A[i-1]==B[j-1]) {
					dp[j]=dp[j-1]+1;
				}else {
					dp[j]=0;
				}
				max=Math.max(max, dp[j]);
			}
		}
		 return max;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
