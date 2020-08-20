package org.lanqiao.algo.elementary._08_dp;

import java.util.stream.Stream;

//https://leetcode-cn.com/problems/palindromic-substrings/
public class 回文子串 {
//  用暴力破解的思路,但是我们可以用动态规划的思想
//  有状态转移方程
  /*
  1.由单个字符组成,必回文
  2.由2个字符组成,字符相同则回文
  3.由多于2个字符组成时,首尾字符相同若剩余子串是回文串则为回文
   */
  public int countSubstrings(String s) {
//    用二维数组记录双指针,列是快指针,行是慢指针
    boolean[][] dp=new boolean[s.length()+1][s.length()+1];
    char[] slen=s.toCharArray();
//记录回文数
    int count=0;
    for (int j = 0; j < s.length(); j++) {
      for (int i=0;i<=j;i++){
        if (i==j){
          count++;
          dp[i][j]=true;
        }else if((j-i)==1 &&slen[i]==slen[j]){
          count++;
          dp[i][j]=true;
        }else{
          if (slen[i]==slen[j]&&dp[i+1][j-1]){
            count++;
            dp[i][j]=true;
          }
        }
      }
    }

   return count;

  }
}
