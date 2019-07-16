package LinkedListEasy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整
 * 数 pos 来表示链表尾连接到链表中的位置
 * （索引从 0 开始）。 如果 pos 是 -1，
 * 则在该链表中没有环。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/12 11:41
 * @Product_Name : leetcode
 */
public class HasCycle141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(3);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(0);
//        node.next.next.next = new ListNode(-4);
//        node.next.next.next.next = node.next;
        ListNode node = null;

        System.out.println(hasCycle1(node));
    }


    // 判断是否有环
    // 判断链表尾是否指向
    // 第一种，使用 哈希表 存储节点地址，然后循环，如果存在相同地址的节点
    //          则说明有环，否则便利到结尾
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    // 第二种 : 双指针，快慢指针 ，如果不存在环，则快指针先到最后
    //          否则快慢指针会相遇
    //      空间复杂度为O(1),因为只用了 两个节点
    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slowNode = head.next;
        ListNode fastNode = head.next.next;
        while (fastNode != null) {
            if (slowNode.equals(fastNode)) {
                return true;
            }
            slowNode = slowNode.next;
            if (fastNode.next != null) {
                fastNode = fastNode.next.next;
            }else{
                return false;
            }
        }
        return false;
    }
}