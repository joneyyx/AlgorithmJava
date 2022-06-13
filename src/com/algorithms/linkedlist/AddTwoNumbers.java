package com.algorithms.linkedlist;

/**
 * @Description No.2
 * @Author ZhongYangyixiong
 * @Date 2022/6/13 7:51 PM
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]

 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new AddTwoNumbers().new Solution();
        ListNode head = solution.addTwoNumbers(l1, l2);
        getNodeData(head);
    }

    public static void getNodeData(ListNode listNode) {
        if(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            getNodeData(listNode);
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            // 初始化链表头
            ListNode cur = pre;
            // 进位符
            int inc = 0;

            while (l1 != null  || l2 != null) {
                int v1 =  l1 == null ? 0 : l1.val;
                int v2 = l2 == null ? 0 : l2.val;

                int add = v1 + v2 + inc;
                inc = add / 10;
                int last = add % 10;

                // 将计算结果赋值给链表头
                cur.next = new ListNode(last);
                cur = cur.next;
                // 移动l1 l2
                if(l1 != null) {
                    l1 = l1.next;
                }
                if(l2  != null) {
                    l2 = l2.next;
                }
            }
            // 链表循环完毕后，如果inc为1，则最后一位指向1
            if(inc == 1) {
                cur.next = new ListNode(1);
            }

            // 返回链表头节点
            return pre.next;
        }
    }

    /**
     * Definition for singly-linked list.
     */


}
