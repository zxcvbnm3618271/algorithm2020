package org.lanqiao.algo.elementary._08_dp;
/*
 * 请设计一种算法，解决著名的n皇后问题。
 * 这里的n皇后问题指在一个nxn的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。
 * 给定一个int n，请返回方法数，保证n小于等于15
 */
public class n皇后问题 {

	public static int sum;
	public int nQueens(int n) {
		sum=0;
		//皇后绝不可能在同一行，假设一行一个皇后，存列
		int[] cols=new int[n];
		helper(cols,n,0);
		return sum;
	}
	//统计方法数
	private void helper(int[] cols,int n,int row) {
		//如果第n个皇后能放在最后一行，则方法数+1
		//否则，方法无效
		if (row==n) {
			sum++;
			return;
		}
		//查看当前行哪一列还能放皇后
		for (int i = 0; i < n; i++) {
			if (isValid(cols,row,i)) {
				cols[row]=i;
				helper(cols, n, row+1);
			}
		}
	}
	//查看第row行第col列是否能放皇后，及当前列无皇后，斜和反斜无皇后
	private boolean isValid(int[] cols,int row,int col) {
		for (int i = 0; i < row; i++) {
			//如果第i行皇后所在的列与当前皇后所在列相同
			if (cols[i]==col) {
				return false;
			}
			//如果当前皇后与第i行皇后的差==当前皇后所在的列-第i行皇后所在的列的绝对值
			//意味着在同一对角线
			if ((row-i)==Math.abs(col-cols[i])) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
