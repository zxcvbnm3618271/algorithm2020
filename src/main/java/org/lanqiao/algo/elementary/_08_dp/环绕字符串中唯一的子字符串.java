package org.lanqiao.algo.elementary._08_dp;

public class 环绕字符串中唯一的子字符串 {
/**
 * https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string/
 * @param args
 */
	/**
	 * 使用动态规划的思想，可以从尾向前找所有连续子序列
	 *  统计以每个字符作为结尾的最长连续序列(可以覆盖掉重复的短序列的情况), 他们的和即为所求
        例如:abcdbcd, 对于以d结尾的有abcd, bcd, cd和d, 而bcd产生的序列都会被abcd所覆盖
        总和即以a、b、c和d结尾的所有连续最长序列1 + 2 + 3 + 4 = 10
     **/
	public int findSubstringInWraproundString(String p) {
		int n=p.length();
		if (n<1) {
			return 0;
		}
		int ret=0;
		int[] count=new int[26];
		char[] str=p.toCharArray();
		int curMaxLen=1;
		for(int i=0;i<n;i++) {
			if (i>0&& (str[i]-str[i-1])==1||str[i-1]-str[i]==25) {
				curMaxLen++;
			}else {
				curMaxLen=1;
			}
			count[str[i]-'a']=Math.max(count[str[i]-'a'], curMaxLen);
		}
		for(int temp:count) {
			ret+=temp;
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
