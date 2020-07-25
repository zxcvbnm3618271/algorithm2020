package org.lanqiao.algo.elementary._08_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 计算右侧小于当前元素的个数 {
/*
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。
 * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
	public List<Integer> countSmaller(int[] nums){
		List<Integer> copy=new ArrayList<>();
		List<Integer> ans=new ArrayList<>();
		int count=0;
		for (int i = nums.length-1; i >= 0; i--) {
			copy.add(nums[i]);
			copy.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1-o2;
				}
			});
			while(copy.get(count)!=nums[i]) {
				count++;
			}
			ans.add(0,count);
			count=0;
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
