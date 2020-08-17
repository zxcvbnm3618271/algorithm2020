package org.lanqiao.algo.elementary;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
//用动态规划dp[m][n]
public class 最小路径和 {

  public int minPathSum(int[][] grid){
//   避免grid[0]报错
    if (grid.length==0){
      return 0;
    }
    //获取m行n列
    int m=grid.length;
    int n=grid[0].length;
    //将dp[0][n]进行初始化
//    将[m][0]进行初始化
    int[][] dp=new int[m+1][n+1];
    dp[0][0]=grid[0][0];
//    对第一列进行初始化
    for (int i=1;i<m;i++){
      dp[i][0]=dp[i-1][0]+grid[i][0];
    }
//    对第一行进行初始化
    for (int i=1;i<n;i++){
      dp[0][i]=dp[0][i-1]+grid[0][i];
    }
    //开始进行动态规划
    for (int i=1;i<m;i++){
      for (int j=1;j<n;j++){
        dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
      }
    }
    return dp[m-1][n-1];
  }
}
