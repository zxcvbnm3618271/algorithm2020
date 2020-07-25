package org.lanqiao.algo.elementary._11_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 二叉搜索树验证 {
	 public static boolean isBalance(List<Integer>A,int pivot){
	        if((pivot*2+1)>=A.size())
	            return true;
	        if(A.get(pivot*2+1)<=A.get(pivot)&&A.get(pivot)<=A.get(pivot*2+2))
	        {
	            return isBalance(A,pivot*2+1)&&isBalance(A,pivot*2+2);
	        }else
	            return false;
	    };
	   
	    public static void main(String[] args){
	        Scanner sc=new Scanner(System.in);
	        String[] s=sc.nextLine().split(",");
	        int i=s.length;
	        List<Integer> A=new ArrayList<Integer>();
	        int j=0;
	        while(i>j){
	        	if (!"None".equals(s[j])) {
	        		A.add(Integer.parseInt(s[j]));
				}
	            
	            j++;
	        }
	        System.out.println(isBalance(A,0)==true?"True":"False");
	    }
}
