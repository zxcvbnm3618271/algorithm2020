package org.lanqiao.algo.elementary.datastructure;

import java.util.LinkedList;

public class 用两个栈实现队列 {

	LinkedList<Integer> stack1=new LinkedList<>();
	LinkedList<Integer> stack2=new LinkedList<>();
	
	//尾插
	public void appendTail(int value) {
		stack1.add(value);
	}
	//头删
	public int deleteHead() {
		if (stack1.isEmpty()) {
			return -1;
		}else {
			while(!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
			int pop=stack2.pop();
			while(!stack2.isEmpty()) {
				stack1.add(stack2.pop());
			}
			return pop;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
