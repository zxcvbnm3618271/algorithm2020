package org.lanqiao.algo.elementary;

public class 魔术索引 {
  public static int findMagicIndex(int[] nums) {
// 利用非降序进行跳跃
    int point=0;
    if(nums[0]>=nums.length)
      return -1;
    while(point<nums.length&&nums[point]!=point){
      if(nums[point]<nums.length&&nums[point]>-1)
        point=nums[point];
      else
        point+=1;
    }
    if(point==nums.length){
      return -1;
    }else{
      return point;
    }
  }
public static void main(String[] args){
    int[] nums={1, 1, 1};
    System.out.println(findMagicIndex(nums));
}

}
