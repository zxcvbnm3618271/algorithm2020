package org.lanqiao.algo.elementary;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Z字形变换 {
  public static String convert(String s,int numRows){
    if (s.isEmpty()||s==""||numRows<=1){
      return s;
    }
    StringBuilder[] stringBuilder=new StringBuilder[numRows];
    int direct=-1;
    int point=0;
    char[] c=s.toCharArray();
    for (int i=0;i<c.length;i++){
      if (stringBuilder[point]==null){
        stringBuilder[point]=new StringBuilder("");
      }
      stringBuilder[point]=stringBuilder[point].append(c[i]);
      if (point==0||point==numRows-1)
        direct=-direct;
      point+=direct;
    }
    return String.join("",stringBuilder).replace("null","");
  }
  public static void main(String[] args){

    String s="LEETCODEISHIRING";
    System.out.println(convert(s,3));
  }
}
