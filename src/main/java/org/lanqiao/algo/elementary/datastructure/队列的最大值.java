package org.lanqiao.algo.elementary.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class 队列的最大值 {
/*
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的
 * 均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1
 */
	public static Deque<Integer> deque=new ArrayDeque<>();
	public static Deque<Integer> help=new ArrayDeque<>();
	 
	    
	    public static int max_value() {
	    	if (help.isEmpty()) {
				return -1;
			}
	    	return help.peek();
	    }
	    
	    public static void push_back(int value) {

	    	deque.addLast(value);
	    	if (help.isEmpty()) {
				help.addFirst(value);
			}else if(value>help.peek()) {
				help.addFirst(value);
			}
	    }
	    
	    public static int pop_front() {
	    	 if(help.isEmpty()){
	                return -1;
	            }
	    	int n=deque.pollFirst();
	    	if (help.peekLast()==n) {
				help.pollLast();
			}
	    	return n;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push_back(1);
		
		 
	}

}
