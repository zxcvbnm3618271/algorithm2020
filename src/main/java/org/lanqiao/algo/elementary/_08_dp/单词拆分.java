package org.lanqiao.algo.elementary._08_dp;

import java.util.HashMap;
import java.util.List;

class 单词拆分 {
	  /*
    动态规划算法，dp[i]表示s前i个字符能否拆分
    转移方程：dp[j] = dp[i] && check(s[i+1, j]);
    check(s[i+1, j])就是判断i+1到j这一段字符是否能够拆分
    其实，调整遍历顺序，这等价于s[i+1, j]是否是wordDict中的元素
    这个举个例子就很容易理解。
    假如wordDict=["apple", "pen", "code"],s = "applepencode";
    dp[8] = dp[5] + check("pen")
    翻译一下：前八位能否拆分取决于前五位能否拆分，加上五到八位是否属于字典
    （注意：i的顺序是从j-1 -> 0哦~
*/
	//将单词存入hashmap方便查询
	public HashMap<String, Boolean> hashMap=new HashMap<>();
	//检查该字符串是否为字典单词
	public boolean check(String s) {
		return hashMap.getOrDefault(s, false);
		
	}
	
	//判断单词能否完全拆分成wordDict的单词
	public boolean wordBreak(String s,List<String> wordDict) {
		boolean[] dp=new boolean[s.length()+1];
		//方便check，构建一个hash表
		for (String word : wordDict) {
			hashMap.put(word, true);
		}
		//初始化
		dp[0]=true;
		
		//通过遍历的方式从前往后验证
		for (int j = 1; j <= s.length(); j++) {
			for (int i = j-1; i >= 0; i--) {
				dp[j]=dp[i] && check(s.substring(i, j));
				if (dp[j]) {
					break;
				}
			}
			
		}
		return dp[s.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
