package tree.binaryTree;

public interface BinaryTree {
    // 是否空树
    public boolean isEmpty();

    // 树结点数量
    public int size();

    // 获取二叉树的高度
    public int getHeight();

    // 查询指定值的结点
    public Node findKey(Object value);

    // 前序递归遍历  根结点  左结点  右结点
    public void preOrderTraverse();

    // 中序递归遍历   左结点  根结点  右结点
    public void inOrderTraverse();

    // 后序递归遍历   左结点  右结点  根结点
    public void postOrderTraverse();

    // 后序递归遍历   左结点  右结点  根结点
    public void postOrderTraverse(Node node);

    // 前序遍历非递归操作
    public void preOrderByStack();

    // 中序遍历非递归操作
    public void inOrderByStack();

    // 后序遍历非递归操作
    public void postOrderByStack();

    // 按照层次遍历二叉树
    public void levelOrderByStack();

}
