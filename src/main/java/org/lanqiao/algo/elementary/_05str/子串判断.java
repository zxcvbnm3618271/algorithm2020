package org.lanqiao.algo.elementary._05str;

import java.util.ArrayList;
import java.util.List;

public class 子串判断 {
	 public static boolean[] chkSubStr(String[] p, int n, String s) {
	        // write code here
		ArrayList<Integer>[] lists= new ArrayList[26];
		for (int i = 0; i < lists.length; i++) {
			lists[i]=new ArrayList<>();
		}
		 int i=0;
		 int pos=0,z=0,q=0,length=0;
		 boolean flag=false;
		 while(i<s.length()) {
			 q=s.charAt(i)-97;
			 lists[q].add(i);
			 i++;
		 }
		 boolean[] bs=new boolean[p.length];
		 for (int j = 0; j < p.length; j++) {
			pos=p[j].charAt(0)-97;
			z=0;
			flag=false;
			length=p[j].length();
			while(flag==false&&z<lists[pos].size()) {
				if (s.substring(lists[pos].get(z),Math.min(lists[pos].get(z)+length, s.length())).equals(p[j])) {
					flag=true;
				}
				z++;
			}
			bs[j]=flag;
			
		}
		return bs;
	    }
	 public static void main(String[] args) {
		 String[] strings= {"a","b","c","d"};
		 String string="abc";
		 boolean[] bs=new boolean[strings.length];
		bs= chkSubStr(strings, 4, string);
		for (boolean b : bs) {
			 System.out.println(b);
		}
		
	 }
}
