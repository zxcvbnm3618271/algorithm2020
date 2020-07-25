package org.lanqiao.algo.elementary._09_Linear;

import java.util.HashMap;

import org.lanqiao.algo.elementary.datastructure.ArrayList;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class 复杂链表的复制 {

	//第一步，将原链表变为A->A'->B->B'
	//第二步，将random的值复制给克隆节点
	//第三步，拆解链表
	 public Node copyRandomList(Node head) {
		 //用这个currentNode进行遍历	
		 
		 Node currentNode=head;
		 //实现第一步
		 while(currentNode!=null) {
			 Node clone=new Node(currentNode.val);
			 clone.next=currentNode.next;
			 currentNode.next=clone;
			 currentNode=clone.next;
		 }
		 //实现第二步
		 currentNode=head;
		 while(currentNode!=null) {
			 Node clone=currentNode.next;
			 clone.random=currentNode.random==null?null:currentNode.random.next;
			 currentNode=currentNode.next.next;
		 }
		 //实现第三步
		 currentNode=head;
		 //记录下复制节点的头
		 Node phead=head.next;
		 while(currentNode!=null) {
			 Node clone=currentNode.next;
			 currentNode.next=clone.next;
			 currentNode=currentNode.next;
			 clone.next=currentNode==null?null:currentNode.next;
			 clone=clone.next;
		 }
		 return phead;
		 	
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
