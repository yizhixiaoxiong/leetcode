package leetcode.a21to30;

import java.util.Map;

/**
 * @Description :
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/17 18:24
 * @Product_Name : leetcode
 */
public class MergeTwoLists21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);

        ListNode newNode = mergeTwoLists(l1, l2);
        System.out.println("新链表为：");
        while (newNode != null){
            int val = newNode.val;
            newNode = newNode.next;
            System.out.print(val+",");
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新链表
        ListNode node = new ListNode(0);
        ListNode newNode = node;
        while (l1 != null && l2 != null) {
            //如果链表
            if (l1.val > l2.val) {
                node.next = new ListNode(l2.val);  //新节点的值等于小的
                node = node.next;
                l2 = l2.next;
            } else {
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            }
        }

        while (l1 != null) {
            node.next = new ListNode(l1.val);
            node = node.next;
            l1 = l1.next;
        }
         while (l2 != null) {
            node.next = new ListNode(l2.val);
            node = node.next;
            l2 = l2.next;
        }
        return newNode.next;
    }
}
