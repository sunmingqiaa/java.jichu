package tree.binaryTree;

public class TestMyBinaryTree {
    public static void main(String[] args) {
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, node5);
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, node7);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node3, node6);
        Node node1 = new Node(1, node4, node2);
        MyBinaryTree binaryTree = new MyBinaryTree(node1);
       /* Node key = binaryTree.findKey(5);
        System.out.println(key);*/
//        binaryTree.preOrderTraverse();
//        binaryTree.inOrderTraverse();
        binaryTree.postOrderTraverse(node1);
    }
}
