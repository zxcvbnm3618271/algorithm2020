package org.lanqiao.algo.elementary;

public class 不同的二叉搜索树 {
/*
给定一个整数 n，
求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
//当1为根节点时,令其左子树数量为0,右子树数量为n-1,
// G(n)表示n个节点时的排序数量
  //F(n)表示当n为根节点时的排序数量
  /*
  有状态转移方程G(n)=F(1)+F(2)+F(3)+...+F(n-1)+F(n)
  F(i)=G(n-i)*G(i-1)
  推出G(n)=G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
   */
public int numTrees(int n) {
  if(n<2){
    return 1;
  }
  int sum=0;
  for (int i=0;i<n;i++){
    sum=sum+numTrees(i)*numTrees(n-1-i);
  }
  return sum;
}
}
