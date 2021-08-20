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

    /*
    * 约瑟夫问题：Josephu(约瑟夫、约瑟夫环)  问题 Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，约定从编号为k（1<=k<=n）的人从1开始报数，
    * 数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
举个例子
n = 5 , 即有5个人
k = 1, 从第一个人开始报数
m = 2, 数2下
    * */
    public void josephuProblem(int k, int m, int n) {
//1、先初始化first和tail变量：first始终指向要出队列的节点。tail始终指向尾部，即first和tail，移动位置m-1
        Boy tail = null;
//        2、然后找到k的位置，让first指向k，tail指向k-1位置，即移动k-1个位置
        for (int i = 0; i < k - 1; i++) {
            tail = first;
            first = first.next;
        }
//        3、让first移动m个位置，让firs指向第m个位置，让tail指向first即可完成出队列操作，直到tail==first，此时还有一个节点，输出即可完成遍历
        while (true) {
            if (tail == first) {
                System.out.println("最后一个出圈" + first.no);
                break;
            }
            for (int i = 0; i < m - 1; i++) {
                tail = first;
                first = first.next;
            }
            System.out.println("出圈" + first.no);
            first = first.next;
//            tail.next.next = null;
            tail.next = first;
        }
    }
}
