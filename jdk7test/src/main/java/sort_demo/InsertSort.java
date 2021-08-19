package sort_demo;

import java.util.Arrays;

public class InsertSort {
    public static Comparable[] sort(Comparable[] a) {
        for (int i = 0; i <=a.length-2; i++) {
            for (int j = i+1; j >=0 ; j--) {
                if (greater(a[j-1],a[j])){
                    exch(a,j,j-1);
                }else {
                    break;
                }
            }

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
        System.out.println(Arrays.toString(InsertSort.sort(a)));

    }
}
