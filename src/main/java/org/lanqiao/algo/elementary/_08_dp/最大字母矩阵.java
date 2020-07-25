package org.lanqiao.algo.elementary._08_dp;

import java.util.HashMap;
import java.util.Map;

public class 最大字母矩阵 {
	//能够组成矩阵的必定是单词一样的
	 public int findAlphaMatrix(String[] dic, int n) {
	        // write code here
		 //利用hashmap统计重复单词数，再从中挑出能组成矩阵的最大值
		 Map<String, Integer> hash=new HashMap<String, Integer>();
		 int Max=Integer.MIN_VALUE;
		 for (int i = 0; i < n; i++) {
			if (hash.containsKey(dic[i])) {
				hash.put(dic[i], hash.get(dic[i])+1);
			}else {
				hash.put(dic[i], 1);
			}
			Max=Math.max(Max,dic[i].length()*hash.get(dic[i]) );
		}
		 return Max;
	    }
	 
}
