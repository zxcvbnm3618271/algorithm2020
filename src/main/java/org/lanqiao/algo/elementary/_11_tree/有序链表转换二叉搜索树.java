package org.lanqiao.algo.elementary._11_tree;


import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class 有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
//        把链表全部提取到list中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedListToBSTHelper(list, 0, list.size() - 1);
    }

    TreeNode sortedListToBSTHelper(List<Integer> list, int left, int right) {
        if (left > right)
            return null;
//        把list中国数据分为两部分
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBSTHelper(list, left, mid - 1);
        root.right = sortedListToBSTHelper(list, mid + 1, right);
        return root;
    }
}
