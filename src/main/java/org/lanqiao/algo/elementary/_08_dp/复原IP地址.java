package org.lanqiao.algo.elementary._08_dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-jin-shuang-100tu-wen-pei-he-by-zu/
 */
public class 复原IP地址 {
//    保存结果
List<String> res = new LinkedList<>();	// 结果

    public List<String> restoreIpAddress(String s){
//        记录长度
        int[] segments = new int[4];
        backtrack(s,0,0,segments);
        return res;
    }

    public void backtrack(String s,int start,int segmentNum,int[] segments){
//        到达结束条件
        if (segmentNum == 4){
            if (start == s.length()){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(segments[i]).append(".");
                }
                sb.append(segments[3]);
                res.add(sb.toString());
            }
            return;
        }
//        提前回溯
        if (start == s.length()){
            return;
        }
//        约束条件,0开头特别处理
        if (s.charAt(start)=='0'){
            segments[segmentNum]=0;
            backtrack(s,start+1,segmentNum+1,segments);
        }
        int temp=0;
        for (int end = start; end < s.length(); end++) {
//            做选择
            if (temp > 0 && temp<=255){
                segments[segmentNum]=temp;
                backtrack(s,end+1,segmentNum+1,segments);
            }else {
                break;
            }
        }
    }
}
