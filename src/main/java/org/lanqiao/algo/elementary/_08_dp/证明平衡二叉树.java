package org.lanqiao.algo.elementary._08_dp;

import sun.reflect.generics.tree.Tree;

public class 证明平衡二叉树 {

//  计算当前节点的高度
  int f(TreeNode root){
    if (root == null){
      return 0;
    }
    return 1+Math.max(f(root.left),f(root.right));
  }
  public boolean isBalanced(TreeNode root){
    if (root == null)
      return true;
    return Math.abs(f(root.left)-f(root.right)) <=1 && isBalanced(root.left)&&isBalanced(root.right);
  }
}
