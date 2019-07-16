package LinkedListEasy;

/**
 * @Description :
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/15 16:19
 * @Product_Name : leetcode
 */
public class TestMyLinkedNode {
    public static void main(String[] args) {
        MyLinkedList707 list = new MyLinkedList707();
//        list.addAtHead(1);
//        list.addAtTail(3);
//        list.addAtIndex(1, 2);
//        int i = list.get(1);
//        list.deleteAtIndex(1);
//        int i1 = list.get(1);
//        System.out.println("完毕");
        //1->
        list.addAtHead(1);
        list.addAtIndex(1, 2);
        int i = list.get(1);
        list.deleteAtIndex(0);
        int i1 = list.get(2);
        System.out.println("完毕");

    }


}
