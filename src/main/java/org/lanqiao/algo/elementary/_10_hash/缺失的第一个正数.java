package org.lanqiao.algo.elementary._10_hash;

public class 缺失的第一个正数 {
/**
 * 
 * @param args
 */
	//这是一道关于原地hashmap的题目
	//i为下标，帮助num[i]的值找到对应位置(通过交换)直到num[i]==i+1(正好找到下标所对应的值)
	//然后i++
	public void swap(int[] nums,int a,int b) {
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
	 public int firstMissingPositive(int[] nums) {
		 int length=nums.length;
		 for (int i = 0; i < length; i++) {
			 //需要注意一种情况：当数组中有两个相同的数时交换可能会陷入死循环
			 //比如nums[0] = 5, nums[4] = 5,i=0时
			while(nums[i]>0&&
					nums[i]<=length&&
					nums[i]!=i+1&&
					nums[i]!=nums[nums[i]-1]) {
				swap(nums, i, nums[i]-1);
			}
		}
		 for (int i = 0; i < length; i++) {
			if (nums[i]!=i+1) {
				return i+1;
			}
		}
		 return length+1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
