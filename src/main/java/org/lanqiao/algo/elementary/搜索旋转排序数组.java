package org.lanqiao.algo.elementary;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 搜索旋转排序数组 {
  public int search(int[] nums, int target) {
  //记录low,high,mid三个指针,由于是旋转数组因此有这样的情况
    /*
    当nums[low]<nums[mid],那么能够保证从low到mid部分都是同一个升序
    当nums[low]>nums[mid],那么能够保证从mid到high部分都是同一个升序
     */
    if (nums.length==0){
      return -1;
    }
    int low=0,high=nums.length-1;
    int mid=0;
    while(low<=high){
      mid=low+(high-low)/2;
      if(nums[mid]==target) {
        return mid;
      }
      //找出同一升序
      if (nums[low]<=nums[mid]){
        if (target>=nums[low]&&target<=nums[mid]){
          high=mid-1;
        }else
          low=mid+1;
      }else{
        if (target>nums[mid]&&target<=nums[high]){
          low=mid+1;
        }else{
          high=mid-1;
        }
      }
    }
    return -1;
  }
  public static void main(String[] args){

  }
}
