package org.lanqiao.algo.elementary;

import java.util.ArrayDeque;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class 判断子序列 {
  public static boolean isSubsequence(String s,String t){
    TreeMap<Character, ArrayDeque> hash=new TreeMap<>();
    int mark=0;
    boolean flag=false;
    char[] characters=t.toCharArray();
     for (int i=0;i<characters.length;i++){
       if (!hash.containsKey(characters[i])){
         hash.put(characters[i],new ArrayDeque());
       }
       hash.get(characters[i]).add(i);
     }
   for (int i=0;i<s.length();i++){
     flag=false;
     if (hash.containsKey(s.charAt(i))){
       while (!hash.get(s.charAt(i)).isEmpty()){
         if (mark<=(int)hash.get(s.charAt(i)).peekFirst()){
           mark=(int)hash.get(s.charAt(i)).peekFirst();
           hash.get(s.charAt(i)).pollFirst();
           flag=true;
           break;
         }
         hash.get(s.charAt(i)).pollFirst();
       }
       if (hash.get(s.charAt(i)).isEmpty()&&flag==false){
         return false;
       }
     }else {
       return false;
     }
   }
    return true;
  }

  public static void main(String[] args){
    String s="abc";
    String t="ahbgdc";
    System.out.println(isSubsequence(s,t));
  }
}
