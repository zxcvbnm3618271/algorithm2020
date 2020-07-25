package org.lanqiao.algo.elementary._09_Linear;
//节点
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 链式加法 {
	 public ListNode plusAB(ListNode a, ListNode b) {
		 //保存进位
		 int temp=0,ta=0;
     ListNode head=a;
		 //模仿整数加法,如果其中一个链表走完，则剩下的链表只需拼接
		 while(a.next!=null&&b.next!=null) {
          ta=a.val;
			 a.val=(temp+a.val+b.val)%10;
			 temp=(temp+ta+b.val)/10;
			 a=a.next;
			 b=b.next;
		 }
		 if (a.next==null) {
			a.next=b.next;
      }//把最后一个对齐的节点运算一下
         ta=a.val;
			 a.val=(temp+a.val+b.val)%10;
			 temp=(temp+ta+b.val)/10;
			 //如果a b链表等长且有进位，则新增一节点
     while(temp!=0){
         if(a.next==null){
             a.next=new ListNode(temp);
             temp=0;
         }else{//如果不等长但是有进位
             a=a.next;
             ta=a.val;
             a.val=(a.val+temp)%10;
             temp=(ta+temp)/10;
         }
     }
		 return head;
	    }
}
