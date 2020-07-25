package org.lanqiao.algo.elementary._11_tree;

import java.util.HashMap;
import java.util.Map;

/*
 * leetcode原题：1028
 */

 class TreeNode {
	 	int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
  }

public class 从先序遍历还原二叉树 {
	public static Map<String, Integer> hash=new HashMap<String, Integer>();
	 public TreeNode recoverFromPreorder(String S) {
		 String[] nums=S.split("-*");
		 
		 		TreeNode head=new TreeNode(S.charAt(0));
		 	return head;	
	    }
	 public static void main(String[] args) {
		 String string="1-2--3--4-5--6--7";
		 String[] strings=string.split("-+");
		 for (String string2 : strings) {
			System.out.println(string2);
		}
	 }
}
