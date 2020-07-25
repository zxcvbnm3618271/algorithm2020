package org.lanqiao.algo.elementary._09_Linear;

public class 链表中倒数第K个节点 {

	//双指针快慢指针就行
	public ListNode getKthFromEnd(ListNode head,int k) {
		ListNode low=head;
		ListNode high=head;
		for(int i=0;i<k;i++) {
			high=high.next;
		}
		while(high!=null) {
			low=low.next;
			high=high.next;
		}
		return low;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
