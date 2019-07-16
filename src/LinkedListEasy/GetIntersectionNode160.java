package LinkedListEasy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description : 相交链表
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/12 13:16
 * @Product_Name : leetcode
 */
public class GetIntersectionNode160 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

//        ListNode first = new ListNode(4);
//        first.next = new ListNode(1);
//
//        ListNode second = new ListNode(5);
//        second.next = new ListNode(0);
//        second.next.next = new ListNode(1);
//
//        ListNode last = new ListNode(8);
//        last.next = new ListNode(4);
//        last.next.next = new ListNode(5);
//
//        first.next.next = last;
//        second.next.next.next = last;


        ListNode first = new ListNode(0);
        first.next = new ListNode(9);
        first.next.next = new ListNode(1);


        ListNode second = new ListNode(3);

        ListNode last = new ListNode(2);
        last.next = new ListNode(4);

        first.next.next.next = last;
        second.next = last;

        ListNode intersectionNode = getIntersectionNode1(first, second);
        System.out.println(intersectionNode.val);

    }

    //找到两个链表相交的第一个
    // 第一种 : 暴力解法，双循环 ，循环一个链表然后将每次都在另一个链表遍历查看是否存在
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersectVal = null;
        ListNode head = headB;
        while (headA != null) {
            intersectVal = headA;
            headB = head;
            while (headB != null) {
                if (intersectVal == headB) {
                    return intersectVal;
                }
                headB = headB.next;
            }
            headA = headA.next;
        }
        return intersectVal;
    }

    //使用哈希表,然后将两个链表依次放入哈希表，如果已经哈希表已经存在，则是相交的点
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode intersectVal = null;
        while (headA != null || headB != null) {
            if (headA != null) {
                if (set.contains(headA)) {//如果存在
                    intersectVal = headA;
                    return intersectVal;
                } else {
                    set.add(headA);
                    headA = headA.next;
                }
            }
            if (headB != null) {
                if (set.contains(headB)) {//如果存在
                    intersectVal = headB;
                    return intersectVal;
                } else {
                    set.add(headB);
                    headB = headB.next;
                }
            }
        }
        return intersectVal;
    }

    //分别将链表转换成两个字符串

}
