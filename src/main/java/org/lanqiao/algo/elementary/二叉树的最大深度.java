package org.lanqiao.algo.elementary;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 *给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root){
      return dfs(root,1);
    }
    public int dfs(TreeNode root,int depth){
      if (root.left==null&&root.right==null){
        return depth;
      }
      return Math.max(dfs(root.left,depth+1),dfs(root.right,depth+1));
    }
}
