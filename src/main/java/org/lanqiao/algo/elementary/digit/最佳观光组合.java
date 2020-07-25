package org.lanqiao.algo.elementary.digit;

import java.util.*;

public class 最佳观光组合 {
	  public static int maxScoreSightseeingPair(int[] A) {
		  if(A.length<2||A.length>50000)
		        return 0;
		  //将int[]转为Integer[]，可以使用java的sort方法降序
         Integer[] a=Arrays.stream(A).boxed().toArray(Integer[]::new);
		  Map<Integer, Integer> hash=new HashMap<Integer, Integer>();
          for (int i = 0; i < a.length; i++) {
			a[i]=a[i]-i;
			while(hash.containsKey(a[i])) {
				a[i]=a[i]+1;
			}
			hash.put(a[i], i);
		}
          Arrays.sort(a,Collections.reverseOrder());
          int Max=A[hash.get(a[0])]+A[hash.get(a[1])]-Math.abs((hash.get(a[0])-hash.get(a[1])));
          return Max;
          
  }
	  public static void main(String[] args) {
		  int[] A= {1,2};
		  System.out.println(maxScoreSightseeingPair(A));
	  }
	
}
