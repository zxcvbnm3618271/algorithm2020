package org.lanqiao.algo.datamining;

import java.util.HashMap;
import java.util.Map;

public class MaxSlide {

	  public int lengthOfLongestSubstring(String s) {
		    int n=s.length();
		    int start=0;
		    int end = 0;
		    int ans = 0;
		    Map<Character,Integer> hash=new HashMap<>();
		    for(;end<n;end++) {
		    	if (hash.containsKey(s.charAt(end))) {
					start=hash.get(s.charAt(end))+1;
				}
		    	hash.put(s.charAt(end), end);
		    	ans=Math.max(ans, end-start+1);
		    }
		    	return ans;
		    }
	public static void main(String[] args) {
		String string="bbbbb";
		System.out.println(new MaxSlide().lengthOfLongestSubstring(string));

	}

}
