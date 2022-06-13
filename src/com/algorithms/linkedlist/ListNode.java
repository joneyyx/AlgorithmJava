package com.algorithms.linkedlist;

/**
 * @author nphc
 */
public class ListNode {
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

    private ListNode createLinkedList(int[] arr) {// 将输入的数组输入到链表中
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {// 过程
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }


    // 以当前节点为头结点的链表信息字符串
    @Override  //为了方便在main函数中看到链表是什么
    public String toString() {

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
