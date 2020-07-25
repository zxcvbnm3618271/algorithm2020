package org.lanqiao.algo.elementary.digit;

public class 最大子方阵 {
/*
 * 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。
给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。
 */
	public int maxSubMatrix(int[][] mat,int n) {
		//从最大子方阵的边长，选择顶点，判断是否符合矩阵
		int maxLength = n;
		while(maxLength>0) {
			for (int i = 0; i <= n-maxLength; i++) {//i是行
				for (int j = 0; j <=n-maxLength; j++) {//j是列  
					int pixel=mat[i][j];
					boolean flag=true;
					for (int k = 0; k < maxLength; k++) {
						int top=mat[i][j+k];//上边的线
						int bottom=mat[i+maxLength-1][j+k];//下边的线
						int left=mat[i+k][j];//左边的线
						int right=mat[i+k][j+maxLength-1];//右边的线
						if (top!=pixel||bottom!=pixel||left!=pixel||right!=pixel) {
							flag=false;
							break;
						}
					}
					//因为是从大到小寻找，可以直接返还
					if (flag) {
						return maxLength;
					}
				}
				
			}
			maxLength--;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
