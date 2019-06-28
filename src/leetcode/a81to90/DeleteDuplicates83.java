package leetcode.a81to90;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 删除排序链表中的重复元素
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/23 23:31
 * @Product_Name : leetcode
 */
public class DeleteDuplicates83 {
    public static class ListNode{
        public int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(3);
        ListNode newNode = deleteDuplicates(head);

        while (newNode != null){
            System.out.print(newNode.val);
            newNode = newNode.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        //有序链表,重复数据,首先想到哈希表
        //想到 key 是链表的值, 值是链表本身(可以取相同元素的最后一个节点)
        if (head == null){
            return null;
        }
        if (head.next ==null){
            return head;
        }
        ListNode tmpNode = new ListNode(head.val);
        ListNode newNode = tmpNode;
        Map<Integer,ListNode> map = new HashMap<Integer, ListNode>();
        map.put(head.val,head );
        while (head != null){
            if (map.containsKey(head.val)){
                head = head.next;       //下一个
            }else{
                tmpNode.next = new ListNode(head.val);
                tmpNode = tmpNode.next;
                map.put(head.val, head);
                head = head.next;
            }

        }
        return newNode;

    }

    public static ListNode deleteDuplicates2(ListNode head){

        //cur和head指向同一个链表对象
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return cur;
    }

}
