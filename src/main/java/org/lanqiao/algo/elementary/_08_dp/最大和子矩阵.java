package org.lanqiao.algo.elementary._08_dp;

public class 最大和子矩阵 {

	//把找出最大和子矩阵的问题转成找数组连续最大和问题
	public static int helper(int[] temp) {
		int tem=temp[0];
		int max=tem;
		for (int i = 1; i < temp.length; i++) {
			if (tem<0) {
				tem=temp[i];
			}else {
				tem+=temp[i];
			}
			max=Math.max(tem, max);
		}
		return max;
	}
	public static int maxsubstrix(int[][] mat,int n) {
		
		int[] temp=mat[0];
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			temp=mat[i];
			max=Math.max(helper(temp),max);
			for (int j = i+1; j < n; j++) {
				for (int k = 0; k < n; k++) {
					temp[k]+=mat[j][k];
				}
				max=Math.max(max, helper(temp));
			}
			
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
