package org.lanqiao.algo.elementary._08_dp;

public class 通配符匹配 {

	/*
	 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
	 */
	//可以使用二维数组记录匹配情况，使用动态规划的解题思路
	public static boolean isMatch(String s,String p) {
		boolean[][] dp=new boolean[s.length()+1][p.length()+1];
		dp[0][0]=true;
		for (int j = 1; j < p.length()+1; j++) {
			if (p.charAt(j-1)=='*') {
				dp[0][j]=dp[0][j-1];
			}
			
		}
		for (int i = 1; i < s.length()+1; i++) {
			for (int j = 1; j < p.length()+1; j++) {
				if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?') {
					dp[i][j]=dp[i-1][j-1];
				}else if (p.charAt(j-1)=='*') {
					dp[i][j]=dp[i][j-1]||dp[i-1][j];
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	public static void main(String[] args) {
		String s="acdcb";
		String p="a*c?b";
		System.out.println(isMatch(s, p));

	}

}
