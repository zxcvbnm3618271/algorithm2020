package org.lanqiao.algo.elementary._08_dp;
/**
 * 
 * @author 233admincol
 *https://leetcode-cn.com/problems/burst-balloons/solution/java-qu-jian-dp-yan-shi-dpfen-xi-fa-xiang-xi-zhu-s/
 */
/*
 * 使用区间dp的解法
 */

public class 戳气球 {
	public int maxCoins(int[] nums) {
		//dp[i][j]表示nums中i到j的气球全部被戳爆的集合
		//dp[i][j]=dp[i][k-1]+dp[k+1][j]+nums[i-1]*nums[k]*nums[j+1]
		int n=nums.length;
		if (n==0) {
			return 0;
		}
		int[][] dp=new int[n+3][n+3];
		int[] s=new int[n+2];
		s[0]=s[n+1]=1;
		for(int i=1;i<=n;i++) {
			s[i]=nums[i-1];
		}
		//一重循环区间长度
		for(int len=1;len<=n;len++) {
			//二重循环遍历数组
			for(int i=1;i+len-1<=n;i++) {
				int j=i+len-1;
				//k遍历找出[i,i+len-1]的最大值
				for(int k=i;k<=j;k++) {
					dp[i][j]=Math.max(dp[i][j], dp[i][k-1]+dp[k+1][j]+s[i-1]*s[k]*s[j+1]);
				}
			}
		}
		return dp[1][n];
	}
}
