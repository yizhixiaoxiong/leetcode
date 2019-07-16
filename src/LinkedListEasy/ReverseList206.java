package LinkedListEasy;

/**
 * @Description :反转链表
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/13 17:57
 * @Product_Name : leetcode
 */
public class ReverseList206 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);


        ListNode result = reverseList1(node);
        while (result != null){
            System.out.print(result.val+",");
            result = result.next;
        }
    }

    //第一种迭代
    //思路:  两个指针，一个指向当前，另一个只想下一个。
    // 新链表
    // 判断: 如果存在下一个，则让下一个指向当前。并将这个链表赋值给新链表，
    //      将当前的这个指针指向下一个继续循环
    //      如果不存在下一个，停止循环，返回新链表
    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode reverseNode = new ListNode(head.val);
        while (head != null){
            ListNode tmp = null;
            if (head.next != null){
                tmp = new ListNode(head.next.val);
                tmp.next = reverseNode;
                reverseNode = tmp;
                head = head.next;
            }else{
                break;
            }
        }
        return reverseNode;
    }

    //这是三指针
    //prev是前面的节点
    //current 是当前节点
    //让当前节点的next指向前节点prev。然后将前节点指向当前节点
    //在循环下一个节点temp
    public static ListNode reverseList1(ListNode head) {
        ListNode prev=null;
        ListNode current = head;
        while(current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }

    //递归

}
