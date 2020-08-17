package org.lanqiao.algo.elementary;

/**
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 */
public class 分割数组的最大值 {
  public int splitArray(int[] nums, int m) {
    // lower: max(nums[i])
    // upper: sum(nums)
    // lower <= k < upper
    long lower = 0, upper = 0, k = 0;
    for (int i = 0; i < nums.length; i++) {
      lower = Math.max(lower, nums[i]);
      upper += nums[i];
    }
    // 进行二分查找
    long mid = 0;
    while (lower < upper) {
      mid = lower + ((upper - lower ) >> 1);
      if(canSplit(nums, m, mid)) {
        upper = mid;
      } else {
        lower = mid + 1;
      }
    }
    if (canSplit(nums, m, lower)) {
      return (int)lower;
    }
    return (int)upper;
  }
  // 检测数组是否能够分成m个非空的连续子数组，并且使得子数组之和的最大值不超过k
  private boolean canSplit(int[] nums, int m, long k) {
    // 当前子数组的sum
    long sum = 0;
    // 当前切分的数量
    long count = 0;
    for (int i = 0; i < nums.length; i++) {
      // 当前子数组和+ nums[i] 大于 k，说明在这需要切分一次，并清空子数组和sum
      if (sum + nums[i] > k) {
        count++;
        sum = 0;
      }
      //  对连续子数组进行相加
      sum += nums[i];
    }
    // 如果最后，切分的次数是小于m，那就说明存在k这样的一个分法的
    // 因为，如果说极限条件是小于m的话，那我想分成m个，
    // 那我只可能切比count更多的次数，意味着子数组和的最大值就更小
    return count < m;
  }
}
