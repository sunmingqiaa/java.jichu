package dataStructure.linkedList;

public class Node {
    public int no;
    public String name;
    public Node next;

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
