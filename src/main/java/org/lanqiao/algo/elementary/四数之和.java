package org.lanqiao.algo.elementary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public List<List<Integer>> fourSum(int[] nums,int target){
  List<List<Integer>> result=new ArrayList<>();
  if (nums==null||nums.length<4){
    return result;
  }
  Arrays.sort(nums);
  int length=nums.length;
  for (int k=0;k<length-3;k++){
    if (k>0&&nums[k]==nums[k-1]){ continue;}
    int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
    if (min1>target){
      break;
    }
    int max1=nums[k]+nums[length-3]+nums[length-2]+nums[length-1];
    if (max1<target){
      continue;
    }
    for (int i=k+1;i<length-2;i++){
      if (i>(k+1)&&nums[i]==nums[i-1]){
        continue;
      }
      int j=i+1;
      int h=length-1;
      int min=nums[k]+nums[i]+nums[j]+nums[j+1];
      if (min>target){
        break;//continue
      }
      int max =nums[k]+nums[i]+nums[h-1]+nums[h];
      if (max<target){
        continue;
      }
      while (j<h){
        int curr=nums[k]=nums[i]+nums[j]+nums[h];
        if (curr==target){
          result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
          j++;
          //这里是去重
          while (j<h&&nums[j]==nums[j-1]){
            j++;
          }
          h--;
          while(j<h&&i<h&&nums[h]==nums[j+1]) {
            h--;
          }
        }else if(curr>target){
          h--;
        }else {
          j++;
        }
      }
    }
  }
return  result;
}
}
