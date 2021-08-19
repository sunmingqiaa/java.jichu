package dataStructure.linkedList.circleLinked;

public class CircleLinked {
    public Boy first;

    /**
     * @param nums 节点个数
     * @Description:创建环形链表
     * @return: void
     */
    public void add(int nums) {
        Boy curBoy = first;

        if (nums < 1) {
            System.out.println("输入节点数不符合规范");
            return;
        }
//        创建节点
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (first == null) {
                first = boy;
                curBoy = boy;
                curBoy.next = first;
            } else {
                curBoy.next = boy;
                curBoy = curBoy.next;
                curBoy.next = first;
            }
        }
    }

    public void showBoy() {
        Boy curBoy = first;
        if (first.next == null) {
            System.out.println("环形链表为空");
            return;
        }
        while (true) {
            if (curBoy.next == first) {
                System.out.println(curBoy.no);
                break;
            }
            System.out.println(curBoy.no);
            curBoy = curBoy.next;
        }
    }
}
