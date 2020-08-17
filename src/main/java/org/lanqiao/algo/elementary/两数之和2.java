package org.lanqiao.algo.elementary;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//使用双指针,有数组num1[]和num2[],指针s1和s2
//  令s1指向num1的开头,s2指向num2的末尾,s1从左往右,s2从右往左,因此有条件:
  /*
  1:当num1[s1]+num2[s2]>target&&num1[s1]<num2[s2],s2--,else s1--
  2.当num[s1]+nums[s2]<target&&num1[s1]<num2[s2],s1++,else s2++
   */
public class 两数之和2 {
  public int[] twoSum(int[] numbers, int target) {
int[] ans=new int[2];
int l=0,h=numbers.length-1;
while(l<=h){
  int sum=numbers[l]+numbers[h];
  if (target==sum) {
    ans[0]=l;
    ans[1]=h;
    return ans;
  }
  else{
    if (sum>target)
      h--;
    else
      l++;
  }
}
return ans;
  }
}
