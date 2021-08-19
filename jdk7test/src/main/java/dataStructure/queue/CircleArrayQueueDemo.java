package dataStructure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircelArray circelArray = new CircelArray(4);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circelArray.showAll();
                    break;
                case 'a':
                    System.out.println("写出要插入的数");
                    circelArray.insert(scanner.nextInt());
                    break;
                case 'g':
                    int data = circelArray.getData();
                    System.out.println("取出的数据是" + data);
                    break;
                case 'h':
                    int i = circelArray.showHead();
                    System.out.println("队列中头数据是" + i);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }

}

class CircelArray {
    public int head;
    public int tail;
    public int[] array;
    public int maxSize;

    public CircelArray(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public boolean isFull() {
        return (tail + 1) % maxSize == head;
    }

    public boolean isNull() {
        return head == tail;
    }

    public void insert(int data) {
        if (isFull()) {
            System.out.println("队列已满，不能添加");
            return;
        }
        array[tail] = data;
        tail = (tail + 1) % maxSize;
    }

    public int getData() {
        int value;
        if (isNull()) {
            System.out.println("队列已经为空");
        }
        value = array[head];
        head = (head + 1) % maxSize;
        return value;
    }

    public int showHead() {
        if (isNull()) {
            System.out.println("队列已经为空");
        }
        return array[head];
    }

    public void showAll() {
        if (isNull()) {
            System.out.println("队列已经为空");
        }
        for (int i = head; i <head+ size(); i++) {
            System.out.println(array[i%maxSize]);
        }
    }

    public int size() {
        return (tail - head + maxSize) % maxSize;
    }
}
