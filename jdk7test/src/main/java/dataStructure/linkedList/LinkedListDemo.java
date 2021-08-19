package dataStructure.linkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(1, "亚索");
        Node node2 = new Node(2, "奶妈");
        Node node3 = new Node(3, "石头");
        Node node4 = new Node(4, "艾希");
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node2);
        linkedList.list();
        System.out.println("反转链表");
        linkedList.reverse();
        linkedList.list();
        linkedList.showNumKFromEnd(1);
        linkedList.showNumKFromEnd(2);
        linkedList.showNumKFromEnd(3);
    }
}
