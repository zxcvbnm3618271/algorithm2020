package org.lanqiao.algo.elementary._08_dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 恢复空格 {
/*
 * leetcode原题：https://leetcode-cn.com/problems/re-space-lcci/
 */
	public static int respace(String[] dictionary,String sentence) {
		int[] dp=new int[sentence.length()+1];
		Set<String> dict=new HashSet<>(Arrays.asList(dictionary));
		dp[0]=0;
		for (int i = 1; i < dp.length; i++) {
			dp[i]=dp[i-1]+1;
			for (int idx = 0; idx <i; idx++) {
				if (dict.contains(sentence.substring(idx,i))) {
					dp[i]=Math.min(dp[i], dp[idx]);
				}
			}
		}
		return dp[sentence.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
