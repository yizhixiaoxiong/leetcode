package LinkedListEasy;

/**
 * @Description :链表的中间结点
 * <p>
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 给定链表的结点数介于 1 和 100 之间。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/14 17:37
 * @Product_Name : leetcode
 */
public class MiddleNode876 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNode(head).val);
    }

    //双指针找链表中点
    public static ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode solw = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.next != null) {
                solw = solw.next;
                fast = fast.next.next;
            }else{
                return solw.next;
            }
        }
        return solw;
    }
}
