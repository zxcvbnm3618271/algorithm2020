package org.lanqiao.algo.elementary._08_dp;

public class 统计和生成所有不同的二叉树 {

	//dp数组保存节点数的所有组合，比如dp[2]=dp[1]*dp[0]+dp[0]*dp[1]
	//解释为2个节点的树由左树节点数为1的所有可能*右树(0)+左树(0)*右树为1的所有可能
	public long sumOfCombination(int num) {
		long[] dp=new long[num+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		for (int i = 3; i <= num; i++) {
			for (int j = 0; j < i; j++) {
				dp[i]=dp[i]+dp[j]*dp[i-j-1];
				dp[i]=dp[i]%(1000000007);
			}
		}
		return dp[num];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
