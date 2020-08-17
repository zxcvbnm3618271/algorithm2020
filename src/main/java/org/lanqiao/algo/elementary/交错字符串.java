package org.lanqiao.algo.elementary;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * https://leetcode-cn.com/problems/interleaving-string/
 *
 */
/*
使用动态规划
 */
public class 交错字符串 {
  public static  boolean isInterleave(String s1, String s2, String s3) {
    int m=s1.length()+1;
    int n=s2.length()+1;
    if ((m+n-2)!=s3.length())
      return false;
    if(s1.length()==0){
    return s2.equals(s3)?true:false;
    }
    if(s2.length()==0){
      return s1.equals(s3)?true:false;
    }
    boolean[][] dp=new boolean[m][n];
    dp[0][0]=true;
    for (int i=1;i<m;i++){
      dp[i][0]=s1.charAt(i-1)==s3.charAt(i-1)?true:false;
      if (dp[i][0]==false) break;;
    }
    for (int i=1;i<n;i++){
      dp[0][i]=s2.charAt(i-1)==s3.charAt(i-1)?true:false;
      if (dp[0][i]==false) break;
    }
    for (int i=1;i<m;i++){
      for (int j=1;j<n;j++){
        dp[i][j]=(dp[i-1][j]||dp[i][j-1])&&(s1.charAt(i-1)==s3.charAt(i+j-1)||s2.charAt(j-1)==s3.charAt(i+j-1));
      }
    }
    return dp[m-1][n-1];
  }
public static void main(String[] args){
    String s1="a";
  String s2="b";
  String s3="ab";
  System.out.println(isInterleave(s1,s2,s3));
}
}
