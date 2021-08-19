package sort_demo;

import java.util.Arrays;

public class ShellSort {
    public static Comparable[] sort(Comparable[] a) {
        //根据数组a的长度，确定增长量h的初始值
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        //希尔排序
        while (h >= 1) {
            //找到待插入的元素
            for (int i = h; i < a.length; i++) {
//                把带插入元素插入到有序数列中
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    } else {
                        break;
                    }

                }

            }
            h = h / 2;
        }

        return a;
    }

    private static void exch(Comparable[] a, int i1, int i2) {
        Comparable tmp;
        tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }

    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 1, 4, 5, 2};
        System.out.println(Arrays.toString(ShellSort.sort(a)));

    }
}
