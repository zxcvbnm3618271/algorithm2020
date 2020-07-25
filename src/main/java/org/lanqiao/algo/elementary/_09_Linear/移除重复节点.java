package org.lanqiao.algo.elementary._09_Linear;

import java.util.HashMap;

import org.junit.experimental.theories.Theories;

public class 移除重复节点 {

	  public HashMap<Integer,Boolean> hash=new HashMap<>();
	    public  ListNode removeDuplicateNodes(ListNode head) {
	        
	        ListNode pre=head;
	        ListNode top=head;
	        hash.put(head.val,true);
	        while(head!=null){
	            head=head.next;
	            if (head==null) {
					break;
				}
	            if(!hash.containsKey(head.val)){
	                hash.put(head.val,true);
	                pre.next=head;
	                pre=pre.next;    
	            }
	        }
	        pre.next=null;
	        return top;
	    }
	public static void main(String[] args) {
		ListNode head=new ListNode(0);
		ListNode top=head;
		head.next=new ListNode(1);
		head=head.next;
		head.next=new ListNode(2);
		head=head.next;
		head.next=new ListNode(3);
		head=head.next;
		head.next=new ListNode(3);
		head=head.next;
		head.next=new ListNode(2);
		head=head.next;
		head.next=new ListNode(1);
		head=head.next;
		top=new 移除重复节点().removeDuplicateNodes(top);
		while(top!=null) {
			System.out.println(top.val);
			top=top.next;
		}
		// TODO Auto-generated method stub

	}

}
