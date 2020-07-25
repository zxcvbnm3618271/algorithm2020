package org.lanqiao.algo.elementary._07_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 派对的最大快乐值 {
/*
 * 整个公司的人员结构可以看作是一棵标准的多叉树。树的头节点是公司唯一的老板，除老板外，每个员工都有唯一的直接上级，叶节点是没有任何下属的基层员工，除基层员工外，每个员工都有一个或多个直接下级，另外每个员工都有一个快乐值。
这个公司现在要办 party，你可以决定哪些员工来，哪些员工不来。但是要遵循如下的原则：
1.如果某个员工来了，那么这个员工的所有直接下级都不能来。
2.派对的整体快乐值是所有到场员工快乐值的累加。
3.你的目标是让派对的整体快乐值尽量大。
给定一棵多叉树，请输出派对的最大快乐值。
 */
	public static void DFS(ArrayList<Integer>[] arr,int[] happy,int root,int[][] dfs) {
		dfs[root][0]=0;//领导不去
		dfs[root][1]=happy[root];//领导去，则快乐值至少为自己快乐值
		//如果不为叶子节点
		if (arr[root]!=null) {
			for (int i = 0; i < arr[root].size(); i++) {
				//获取root的子节点
				int j= arr[root].get(i);
			DFS(arr, happy, j, dfs);
			dfs[root][0]+=Math.max(dfs[j][0], dfs[j][1]);
			dfs[root][1]+=dfs[j][0];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String[] str1=bufferedReader.readLine().split(" ");
		int num=Integer.parseInt(str1[0]);//公司总人数
		int N= num +1;
		int root=Integer.parseInt(str1[1]);//根节点
		String[] str2=bufferedReader.readLine().split(" ");
		int[] happy=new int[N];
		for (int i = 0; i < num; i++) {
			happy[i+1]=Integer.parseInt(str2[i]);//每个员工的快乐值
		}
		//将父节点对应子节点存入arrayLists中
		ArrayList<Integer>[] arrayLists=new ArrayList[N];
		for (int i = 0; i < num-1; i++) {
			String[] strings=bufferedReader.readLine().split(" ");
			int u=Integer.parseInt(strings[0]);//起点
			int v=Integer.parseInt(strings[1]);//终点
			if (arrayLists[u]==null) {
				arrayLists[u]=new ArrayList<>();
			}
			arrayLists[u].add(v);
		}
		//保存每个父节点选择自己和不选择自己的结果
		int[][] dfs=new int[arrayLists.length][2];
		DFS(arrayLists, happy, root, dfs);
		System.out.println(Math.max(dfs[root][0], dfs[root][1]));
		

	}

}
