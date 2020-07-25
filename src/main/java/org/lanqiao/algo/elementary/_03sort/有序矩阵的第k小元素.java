package org.lanqiao.algo.elementary._03sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素
 */
public class 有序矩阵的第k小元素 {
	 public static int kthSmallest(int[][] matrix, int k) {
		if (matrix.length==0) {
			return -1;
		}
		 //建立大顶堆
		 PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
		 @Override
			 public int compare(Integer o1,Integer o2) {
			 return o2.compareTo(o1);
		 } 
		 });
		 int length=Math.min(matrix.length, k);
		 for (int i = 0; i < matrix.length; i++) {
			for (int j=0; j < length; j++) {
				if (priorityQueue.size()!=k) {
					priorityQueue.add(matrix[i][j]);
				}else {
				if (matrix[i][j]<priorityQueue.peek()) {
					priorityQueue.poll();
					priorityQueue.add(matrix[i][j]);
				}
				}
			}
		}
		 return priorityQueue.peek();
	    }
	 public static void main(String[] args) {
		 int[][] matrix= {{1,5,9},{10,11,13},{12,13,15}};
		 System.out.println(kthSmallest(matrix, 8));
	 }
}
