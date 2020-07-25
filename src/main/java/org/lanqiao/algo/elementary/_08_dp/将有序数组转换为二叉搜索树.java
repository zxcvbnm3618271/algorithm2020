package org.lanqiao.algo.elementary._08_dp;

class TreeNode {
	     int val;
	      TreeNode left;
	     TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public class 将有序数组转换为二叉搜索树 {
/*
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
	public TreeNode sortedArrayToBST(int[] nums) {
		//使用递归的方式进行分治，也就是将数组化为
		//左子树和右子树
		return dfs(nums,0,nums.length-1);
	}
	private TreeNode dfs(int[] nums,int l,int r) {
		if (l>r) {
			return null;
		}
		//以升序数组的中间元素作为根节点root
		int mid=l+(r-l)/2;
		TreeNode root=new TreeNode(nums[mid]);
		root.left=dfs(nums, l, mid-1);
		root.right=dfs(nums, mid+1, r);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
