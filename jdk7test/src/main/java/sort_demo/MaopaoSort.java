package sort_demo;

import java.util.Arrays;

public class MaopaoSort {
    public static Comparable[] sort(Comparable[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exch(a, j);
                }
            }
        }
        return a;
    }
    private static void exch(Comparable[] a, int j) {
        Comparable tmp;
        tmp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = tmp;
    }
    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 2, 1, 5, 2};
        System.out.println(Arrays.toString(MaopaoSort.sort(a)));

    }
}
