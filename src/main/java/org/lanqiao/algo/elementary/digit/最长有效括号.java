package org.lanqiao.algo.elementary.digit;

public class 最长有效括号 {

	public static int longestValidParentheses(String s) {
		char[] chars=s.toCharArray();
		return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length-1, -1, -1, ')'));
	}
	
	private static int calc(char[] chars,int i,int flag,int end,char cTem) {
		int max=0,sum=0,currLen=0,validLen=0;
		for (; i != end; i+=flag) {
			sum+=(chars[i]==cTem?1:-1);
			currLen++;
			if (sum<0) {//当sum小于0时，连续有效长度中断，需要进行结算
				//因为只有sum小于0才进行结算，比如"((())"正序就结算不了，因此需要进行逆序。
				max=Math.max(max, validLen);
				sum=0;
				currLen=0;
				validLen=0;
			}else if (sum==0) {//当sum为0时，满足有效括号
				validLen=currLen;
			}
		}
		return Math.max(max, validLen);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String string="((())";
System.out.println(longestValidParentheses(string));
	}

}
