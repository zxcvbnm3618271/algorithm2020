package org.lanqiao.algo.elementary._04matrix;

public class 顺时针打印矩阵 {

	//通过设定边界解决问题
	 public static int[] spiralOrder(int[][] matrix) {
		 if (matrix.length==0) {
			return new int[0];
		}
		 int l=0,t=0;
		 int r=matrix[0].length,b=matrix.length;
		 int[] ans=new int[r*b];
		 int pivot=0;
		 while(true) {
			 //从左往右
			 for(int i=l;i<=r-1;i++) {
				ans[pivot++]=matrix[t][i];
				
			 }
			 if (++t>=b) break;
			 //从上往下
			 for(int i=t;i<=b-1;i++) {
					ans[pivot++]=matrix[i][r-1];
				 }
				 if (--r<=l) break;
			//从右往左
				 for(int i=r-1;i>=l;i--) {
						ans[pivot++]=matrix[b-1][i];
					 }
					 if (--b<=t) break;
			//从下往上
					 for(int i=b-1;i>=t;i--) {
							ans[pivot++]=matrix[i][l];
						 }
						 if (++l>=r) break;
		 }
		 return ans; 
	    }
	
	 //通过
	
	public static void main(String[] args) {
		int[][] matrix= {{1,2,3,10},{4,5,6,11},{7,8,9,12}};
		int[] ans=spiralOrder(matrix);
		for (int i : ans) {
			System.out.print(i+" ");
		}
	}
}
