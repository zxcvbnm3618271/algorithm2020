package org.lanqiao.algo.elementary._08_dp;

public class 最长公共子序列 {
//具体题解查看
//https://leetcode-cn.com/problems/longest-common-subsequence/solution/java-dong-tai-gui-hua-tu-wen-jie-xi-by-sdwwld/
	public int longestCommonSubsequence(String str1, String str2) {
	if (str1==null||str2==null||str1.length()==0||str2.length()==0) {
		return 0;
	}
	int[][] dp=new int[str1.length()+1][str2.length()+1];
	for (int i = 1; i <= str1.length(); i++) {
		for (int j = 1; j <=str2.length() ; j++) {
			if (str1.charAt(i-1)==str2.charAt(j-1)) {
				dp[i][j]=dp[i-1][j-1]+1;
			}else {
				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	return dp[str1.length()][str2.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
