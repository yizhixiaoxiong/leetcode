package LinkedListEasy;

import java.util.Stack;

/**
 * @Description : 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/14 9:59
 * @Product_Name : leetcode
 */
public class IsPalindrome234 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(node));
    }

    //O(n)即以此循环

    //使用stack存储
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        ListNode n = head;
        while (head != null){
            stack.push(head.val);
            head = head.next;
            count++;
        }

        for (int i = 0; i < count/2; i++) {
            if (n.val == stack.peek()){
                stack.pop();
                n = n.next;
            }else{
                return false;
            }
        }
        return true;
    }
}
