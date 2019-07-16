package LinkedListEasy;

/**
 * @Description :设计链表
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表
 * <p>
 * 假设链表中的所有节点都是 0-index 的。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/15 15:54
 * @Product_Name : leetcode
 */
public class MyLinkedList707 {

    public MyListNode node;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList707() {
        //为了方便，链表头尾-1起步,下标也计为-1
        node = new MyListNode(-1);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int k = -1;
        MyListNode temp = node;
        while (temp != null) {
            temp = temp.next;
            k++;
            if (k == index) {
                return temp.val;
            }
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        node.next = new MyListNode(val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyListNode temp = node;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = new MyListNode(val);
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0){
            node.next = node.next.next;
        }
        int k = -1;
        MyListNode temp = node;
        while (temp != null) {
            k++;
            if (k == index) {
                if (temp.next != null) {
                    MyListNode tmp = temp.next;
                    temp.next = new MyListNode(val);
                    temp.next.next = tmp;
                    break;
                }else{//如果index等于链表长度,追加到末尾
                    temp.next = new MyListNode(val);
                }
            }
            temp = temp.next;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int k = -1;
        MyListNode temp = node;
        while (temp != null){

            k++;
            if (k == index){
                if (temp.next != null){
                    temp.next = temp.next.next;
                    break;
                }else{
                    System.out.println("无效index");
                    break;
                }
            }
        }
        if (k < index-1){
            System.out.println("无效索引index");
        }
    }
}
