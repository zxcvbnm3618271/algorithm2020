package org.lanqiao.algo.elementary._08_dp;

public class 不同路径统计 {
/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid==null || obstacleGrid.length==0) {
			return 0;
		}
		//定义dp数组并声明第一行和第一列
		int m=obstacleGrid.length,n=obstacleGrid[0].length;
		int[][] dp=new int[m][n];
		for (int i = 0; i < m&&obstacleGrid[i][0]==0; i++) {
			dp[i][0]=1;
		}
		for(int j=0;j<n&&obstacleGrid[0][j]==0;j++) {
			dp[0][j]=1;
		}
		//根据状态转移方程的dp[i][j]=dp[i-1][j]+dp[i][j-1]进行递归
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j]==0) {
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
