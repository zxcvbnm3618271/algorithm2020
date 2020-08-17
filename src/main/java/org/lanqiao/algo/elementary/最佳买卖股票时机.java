package org.lanqiao.algo.elementary;

public class 最佳买卖股票时机 {
  public int maxProfit(int[] prices) {
      int n=prices.length;
      if (n==0)
        return 0;
      //每天持有股票时的最大收益
      int[] hold=new int[n];
      hold[0]=-prices[0];
      //当天卖出股票时的最大收益
      int[] nothold=new int[n];
      for (int i = 1;i<n;i++){
        if (i>=2)
          hold[i]=Math.max(hold[i-1],nothold[i-2]-prices[i]);
        else
          hold[i]=Math.max(hold[i-1],-prices[i]);
        nothold[i]=Math.max(nothold[i-1],hold[i-1]+prices[i]);
      }
      return nothold[n-1];
  }
}
