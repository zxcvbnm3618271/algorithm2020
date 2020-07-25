package org.lanqiao.algo.book.niuke;

import java.util.Arrays;

class TreeNode {
	     int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class 根据前序中序建树 {
//使用递归思想
	/**
	 * 重复的子问题:跟据前序中序建树
	 * 变化的部分:前序区间和中序区间
	 * 边界:当前序区间为空时
	 * @param preorder 前序区间
	 * @param inorder 中序区间
	 * @return
	 */
	public TreeNode buildTree(int[] preorder,int[] inorder) {
		int n=preorder.length;
		if (n==0) {
			return null;
		}
		//前序区间的第一个数就是子树的根
		int rootVal =preorder[0],rootIndex=0;
		//去中序区间找根的位子,找出左子树和右子树
		for(int i=0;i<n;i++) {
			if (inorder[i]==rootVal) {
				rootIndex=i;
				break;
			}
		}
		//记下子树的根,递归后的最后一个root就是整个树的根
		TreeNode root=new TreeNode(rootVal);
		//让左子树继续建树
		root.left=buildTree(Arrays.copyOfRange(preorder, 1, 1+rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
		//让右子树继续建树
		root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(inorder, rootIndex + 1, n));
	return root;
	}
}
