package sort_demo;

import java.util.Arrays;

public class SelectSort {
    public static Comparable[] sort(Comparable[] a) {
        for (int i = 0; i <=a.length-2; i++) {
            int minIndex=i;
            for (int j = i+1; j <a.length; j++) {
                if (greater(a[minIndex], a[j ])) {
                    exch(a, minIndex, j);
                }
            }
        }
        return a;
    }

    public static void exch(Comparable[] a, int i1, int i2) {
        Comparable tmp;
        tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }

    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 2, 1, 5, 2};
        System.out.println(Arrays.toString(SelectSort.sort(a)));

    }
}
