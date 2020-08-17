package org.lanqiao.algo.elementary;

public class 最长回文子串 {
  public String longestPalindrome(String s) {
    // 进行逆序,将最长回文子串的问题转为找最长公共子串的问题
    StringBuilder r=new StringBuilder(s);
    r=r.reverse();
    int m=s.length();
    int max=0;
    int point=0;
    int[][] dp=new int[m+1][m+1];
  //将第一行和第一列初始化为0
  for (int i=0;i<dp.length;i++){
    dp[i][0]=0;
    dp[0][i]=0;
  }
  for (int i=1;i<dp.length;i++){
    for (int j=1;j<dp[0].length;j++){
      if (s.charAt(i)==r.charAt(i)){
        dp[i][j]=dp[i-1][j-1]+1;
        if (dp[i][j]>max){
          max=dp[i][j];
          point=i;
        }
      }
    }
  }

  return s.substring(point-max,point);
  }
}
