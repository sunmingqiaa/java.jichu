package tree.binaryTree;

public class Node {
    public int value;
    public Node left;
    public Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
