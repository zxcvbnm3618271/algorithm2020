package org.lanqiao.algo.elementary._08_dp;

public class 移除盒子消消乐 {
    private int[][][] dp;
    private int[] _boxes;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        if(n==0)return 0;
        _boxes = boxes;
        dp = new int[n][n][n];
        return helper(0,n-1,0);
    }

    private int helper(int l,int r,int p){
        if(l>r) return 0;
        if(dp[l][r][p]>0)return dp[l][r][p];
        while(r>l&&_boxes[r]==_boxes[r-1]){
            r--;
            p++;
        }
        dp[l][r][p] = helper(l,r-1,0)+(p+1)*(p+1);
        for(int k=r-1;k>=l;k--){
            if(_boxes[k]==_boxes[r]){
                dp[l][r][p] = Math.max(dp[l][r][p],helper(l,k,p+1)+helper(k+1,r-1,0));
            }
        }
        return dp[l][r][p];
    }
}
