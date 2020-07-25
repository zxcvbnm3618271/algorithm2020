package org.lanqiao.algo.elementary._03sort;

import java.util.Arrays;

public class 最接近的三数之和 {

	 public static int threeSumClosest(int[] nums, int target) {
		 //先对数组进行排序，使用快排，为nlogn
		 Arrays.sort(nums);
		 //定义三个变量i，start，end，i为基准，start和end是头指针和尾指针
		
		 int length=nums.length;
		 int start=1,end=length-1;
		 int sum=nums[0]+nums[1]+nums[length-1],temp=0;
		 for (int i = 0; i < length-1; i++) {
			 start=i+1;
			 end=length-1;
			 while(sum!=target&&start!=end) {
				 temp=nums[i]+nums[start]+nums[end];
				 if (temp-target>0) {
					end--;
				}else {
					start++;
				}
				 if (Math.abs(target-sum)>Math.abs(target-temp)) {
					sum=temp;
				}
			 }
		}
		 return sum;
	    }
	public static void main(String[] args) {
		int target=1;
		int[] nums= {-1,2,1,-4};
		System.out.println(threeSumClosest(nums, target));
		
		// TODO Auto-generated method stub

	}

}
