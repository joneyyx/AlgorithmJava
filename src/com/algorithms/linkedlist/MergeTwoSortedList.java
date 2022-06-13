package com.algorithms.linkedlist;

/**
 * @Description 合并两个有序链表No.21
 * @Author ZhongYangyixiong
 * @Date 2022/6/13 10:14 PM
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        Solution solution = new MergeTwoSortedList().new Solution();
        ListNode listNode = solution.mergeTwoLists(list1, list2);
        System.out.println(listNode);

        Solution2 solution2 = new MergeTwoSortedList().new Solution2();
        ListNode listNode2 = solution2.mergeTwoLists(list1, list2);
        System.out.println(listNode2);
    }


    /**
     * 时间复杂度：
     * O(n+m)
     * O(n+m)，其中n和m 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。
     * 所有其他操作的时间复杂度都是常数级别的，
     * O(n+m)。
     * 空间复杂度：
     * O(1)。我们只需要常数的空间存放若干变量。
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }

            // 定义指针pre、cur
            ListNode pre = new ListNode(0);
            ListNode cur = pre;

            while (list1 != null && list2 != null) {
                int v1 = list1.val;
                int v2 = list2.val;
                if(v1 <= v2) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                // 重要：cur = cur.next
                cur = cur.next;
            }
            // 处理最后一个节点
            cur.next = list1 == null ? list2 : list1;
            return pre.next;
        }
    }

    class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null) {
                return  list2;
            } else if(list1 == null) {
                return list1;
            } else if(list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return  list2;
            }
        }
    }
}
