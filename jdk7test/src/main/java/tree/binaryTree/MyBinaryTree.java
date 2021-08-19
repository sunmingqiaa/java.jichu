package tree.binaryTree;

public class MyBinaryTree implements BinaryTree {
    private Node root;

    public MyBinaryTree(Node node1) {
        this.root=node1;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        System.out.print("二叉树的结点个数是：");
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            // 获取左子树的size
            int nl = this.size(root.left);
            // 获取右子树的size
            int nr = this.size(root.right);
            // 取较大值加1即可
            return nl + nr + 1;
        }

    }

    @Override
    public int getHeight() {
        System.out.print("二叉树的高度是：");
        return getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            // 获取左子树的高度
            int nl = this.getHeight(root.left);
            // 获取右子树的高度
            int nr = this.getHeight(root.right);
            // 取较大值加1即可
            return nl > nr ? nl + 1 : nr + 1;
        }
    }

    @Override
    public Node findKey(Object value) {
        Node reNode = findKey(value, root);
        return reNode;
    }

    private Node findKey(Object value, Node root) {
        if (root.value == value) {
            return root;
        }
        Node resNode = null;
        if (root.left != null) {
            resNode = findKey(value, root.left);
        }
        if (resNode!=null){
            return resNode;
        }
        if (root.right != null) {
            resNode = findKey(value, root.right);
        }
        return resNode;
    }

    @Override
    public void preOrderTraverse() {
        preOrderTraverse(root);

    }
    private void preOrderTraverse( Node root) {
        if (root != null) {
            System.out.println(root.value);
        }
        if (root.left != null) {
            preOrderTraverse(root.left);
        }
        if (root.right != null) {
            preOrderTraverse(root.right);
        }

    }
    @Override
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }
    private void inOrderTraverse( Node root) {
        if (root.left != null) {
            preOrderTraverse(root.left);
        }
        if (root != null) {
            System.out.println(root.value);
        }
        if (root.right != null) {
            preOrderTraverse(root.right);
        }}
    @Override
    public void postOrderTraverse() {
        postOrderTraverse( root);
    }
    @Override
    public void postOrderTraverse(Node root) {
        if (root.left != null) {
            postOrderTraverse(root.left);
        }

        if (root.right != null) {
            postOrderTraverse(root.right);
        }

        System.out.println(root.value);

    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void inOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void levelOrderByStack() {

    }
}
