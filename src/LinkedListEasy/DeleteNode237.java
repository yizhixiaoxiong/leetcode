package LinkedListEasy;

/**
 * @Description :  删除链表中的节点
 * <p>
 * 请编写一个函数，使其可以删除某个链表
 * 中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 示例 1:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的
 * 函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函
 * 数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 说明:
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/14 16:10
 * @Product_Name : leetcode
 */
public class DeleteNode237 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        deleteNode(head.next);

        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
