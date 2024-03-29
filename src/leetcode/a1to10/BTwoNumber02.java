package leetcode.a1to10;

import java.math.BigDecimal;

/**
 * @Description :
 *  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 *  并且它们的每个节点只能存储 一位 数字。
 *  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/10 23:33
 * @Product_Name : Algorithm
 */
public class BTwoNumber02 {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9);
//
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(9);
        l1.next.next= new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next= new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(7);


        ListNode listNode = addTwoNumbers(l1, l2);
        ergodic(listNode);


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void ergodic(ListNode node) {
        StringBuffer str = new StringBuffer();
        while (node != null) {
            str.append(node.val);
            node = node.next;
        }
        char[] chars = str.toString().toCharArray();
        for (char c : chars) {
            System.out.print(c);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode l3 = null;
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        while (node1 != null) {
            str1.append(node1.val);
            node1 = node1.next;
        }
        while (node2 != null) {
            str2.append(node2.val);
            node2 = node2.next;
        }
        str1.reverse();
        str2.reverse();
        BigDecimal sum1 = new BigDecimal(str1.toString());
        BigDecimal sum2 = new BigDecimal(str2.toString());
        BigDecimal sum = sum1.add(sum2);
        if (sum.compareTo(new BigDecimal(0)) >= 0) {
            String s = String.valueOf(sum).trim();
            int arrs[] = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arrs[i] = Integer.parseInt(s.substring(i, i + 1));
            }
            node = new ListNode(arrs[s.length() - 1]);
            l3 = node;
            for (int i = arrs.length - 2; i >= 0; i--) {
                node.next = new ListNode(arrs[i]);
                node = node.next;
            }
        }
        return l3;
    }

}
