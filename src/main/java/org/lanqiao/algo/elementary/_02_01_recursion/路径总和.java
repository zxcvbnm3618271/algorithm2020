package org.lanqiao.algo.elementary._02_01_recursion;

import org.lanqiao.algo.TreeNode;

public class 路径总和 {
//leetcode122题 ：路经总和
	public boolean hasPathSum(TreeNode<Integer> root,int sum) {
		if(root==null) {
			return false;
		}
		if (sum-root.val==0&&root.left==null&&root.right==null) {
			return true;
		}
		return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
