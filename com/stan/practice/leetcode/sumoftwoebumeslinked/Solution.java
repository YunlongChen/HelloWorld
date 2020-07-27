package com.stan.practice.leetcode.sumoftwoebumeslinked;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: 陈云龙
 * @date: 2020/7/27
 * @description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public static void main(String[] args) {

        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{3, 4, 5};

        ListNode l1, l2;
        ListNode node;
        for (int num : num1) {
            node = new ListNode(num);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> input1 = new LinkedList<>();
        List<Integer> input2 = new LinkedList<>();
        ListNode node1, node2;
        node1 = l1;
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }

        node2 = l2;
        while (node2 != null) {
            System.out.println(node2.val);
            node1 = node2.next;
        }

        return new ListNode(1);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
