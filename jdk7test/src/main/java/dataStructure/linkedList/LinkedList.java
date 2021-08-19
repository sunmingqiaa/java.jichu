package dataStructure.linkedList;

@SuppressWarnings("all")
public class LinkedList {
    private Node head = new Node(0, null);

    /**
     * @Description:添加节点
     * @param node
     * @return: void
     */
    public void add(Node node) {
        Node tmp = head;
        while (true) {
            if (tmp.next != null) {
                tmp = tmp.next;
            } else {
                tmp.next = node;
                break;
            }
        }
    }

    /**
     * @Description:遍历链表
     * @return: void
     */
    public void list() {
        Node tmp = head;
        if (head.next == null) {
            System.out.println("链表为空");
        } else {
            while (true) {
                if (tmp.next != null) {
                    System.out.println(tmp.next);
                    tmp = tmp.next;
                } else break;
            }
        }
    }

    /**
     * @param node
     * @Description:按节点编号no顺序添加节点
     * @return: void
     */
    public void addByOrder(Node node) {
        Node tmp = head;
        while (true) {
            if (tmp.next == null) {
                tmp.next = node;
                break;
            } else if (tmp.next.no == node.no) {
                System.out.println("不能插入重复编号" + node.no);
                break;
            } else if (tmp.next.no > node.no) {
                node.next = tmp.next;
                tmp.next = node;
                break;
            } else {
                tmp = tmp.next;
            }
        }


    }

    /**
     * @param k
     * @Description:查找倒数第k个节点
     * @return: void
     */
    public void showNumKFromEnd(int k) {
        int size = 0;
        Node tmp = head;
        Node cur = head.next;
        if (head.next == null) {
            System.out.println("链表为空");
        } else {
            while (true) {
                if (tmp.next != null) {
                    size++;
//                    System.out.println(tmp.next);
                    tmp = tmp.next;
                } else break;
            }
        }
        for (int i = 0; i < size - k; i++) {
            cur = cur.next;
        }
        System.out.println(cur);
    }

    /**
     * @Description:反转链表
     * @return: void
     */
    public void reverse() {

        if (head.next == null || head.next.next == null) {
            return;
        }
        Node cur = head.next;
        Node next = null;
        LinkedList newLinked = new LinkedList();
        Node newHead = newLinked.head;
        while (cur != null) {
            next = cur.next;
            cur.next= newHead.next;
//            newHead.next=cur.next;
            newHead.next =cur;
            cur = next;
        }
        head.next = newHead.next;
    }
}
