package org.lanqiao.algo.elementary;

import java.util.List;

public class 三角形最小路径和 {
  public int minimumTotal(List<List<Integer>> triangle) {
//现找出状态转移方程
    //解法1
//    int n = triangle.size();
//    int[][] f = new int[n][n];
//    f[0][0] = triangle.get(0).get(0);
//    for (int i = 1; i < n; ++i) {
//      f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
//      for (int j = 1; j < i; ++j) {
//        f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
//      }
//      f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
//    }
//    int minTotal = f[n - 1][0];
//    for (int i = 1; i < n; ++i) {
//      minTotal = Math.min(minTotal, f[n - 1][i]);
//    }
//    return minTotal;
   //解法2
//    int n=triangle.size();
//    int [][] dp=new int[2][n];
//    dp[0][0]=triangle.get(0).get(0);
//    for (int i=1;i<n;i++){
//      int curr=i%2;
//      int prev=1-curr;
//      dp[curr][0]=dp[prev][0]+triangle.get(i).get(0);
//      for (int j=1;j<i;j++){
//        dp[curr][j]=Math.min(dp[prev][j-1],dp[prev][j])+triangle.get(i).get(j);
//      }
//      dp[curr][i]=dp[prev][i-1]+triangle.get(i).get(i);
//    }
//    int minTotal=dp[(n-1)%2][0];
//    for (int i=1;i<n;i++){
//      minTotal=Math.min(minTotal,dp[(n-1)%2][i]);
//    }
//    return minTotal;
    //解法3
    int n = triangle.size();
    int[] dp=new int[n];
    dp[0]= triangle.get(0).get(0);
    for (int i = 1;i<n;i++){
      dp[i]=dp[i-1]+triangle.get(i).get(i);
      //从后往前可以不用保存上一行的dp
      for (int j=i-1;j>0;j--){
        dp[j]=Math.min(dp[j-1],dp[j])+triangle.get(i).get(j);
      }
      dp[0]+=triangle.get(i).get(0);
    }
    int minTotal=dp[0];
    for (int i=1 ;i<n;i++){
      minTotal=Math.min(minTotal,dp[i]);
    }
    return minTotal;
  }
}
