package LinkedListEasy;

/**
 * @Description : 移除链表元素
 * <p>
 * 示例：
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/13 14:13
 * @Product_Name : leetcode
 */
public class RemoveElements203 {

    public static void main(String[] args) {
        ListNode node = new ListNode(6);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);

        int val = 6;

        ListNode result = removeElements(node, val);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }

    //遍历，相等就删除，并将指针指向下一个
    //两种方式：
    // 1. 循环两次，第一次循环找到不是val的第一个节点,
    //    第二次循环找到其他不是val的节点。但时间复杂度是O(N)
    // 2. 第一种的变种。用一个虚拟节点当哨兵,然后循环找到不是val的节点
    public static ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode result = tmp;
//        while (head != null) {
//            if (head.val == val) {
//                head = head.next;
//            } else {
//                result = head;
//                break;
//            }
//        }
        //循环
        while (tmp != null) {
            if (tmp.next != null) {
                if (tmp.next.val != val) {
                    tmp = tmp.next;
                } else {
                    tmp.next = tmp.next.next;
                }
            }else{
                break;
            }
        }
        return result.next;
    }
}
