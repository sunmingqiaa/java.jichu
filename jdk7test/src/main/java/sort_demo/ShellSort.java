package sort_demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class ShellSort {
    public static void sort02(int[] arr) {
        int h = arr.length / 2;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int index = i;
                int tmp = arr[index];
//                if (arr[index] < arr[index - gap]) {
                    while (index - gap >= 0 && tmp < arr[index - gap]) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    arr[index] = tmp;
//                }
            }

        }

    }

    public static Comparable[] sort(Comparable[] a) {
        //根据数组a的长度，确定增长量h的初始值
        int h = a.length / 2;
//        while (h < a.length / 2) {
//            h = 2 * h + 1;
//        }

        for (int x = h; h > 0; h /= 2) {
            for (int i = h; i < a.length; i++) {
//                把带插入元素插入到有序数列中

                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    }

                }

            }
        }
        //希尔排序
      /*  while (h >= 1) {
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
        }*/

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
//        Integer[] a = {1, 2, 3, 1, 4, 5, 2};
        int[] arr = {3, 1, 4, 2, 7, 0};
        int[] integers = new int[20000000];
        for (int i = 0; i < 20000000; i++) {
            integers[i] = (int) Math.random() * 80000000;
        }
        ShellSort.sort02(arr);
        System.out.println(Arrays.toString(arr));

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format1 = format.format(date);
        System.out.println(format1);
        ShellSort.sort02(integers);
        Date date2 = new Date();
        String format2 = format.format(date2);
        System.out.println(format2);
    }
}
