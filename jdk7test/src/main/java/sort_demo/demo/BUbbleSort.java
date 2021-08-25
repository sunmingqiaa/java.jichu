package sort_demo.demo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BUbbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int tmp;
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }

            }
            if (flag = true) {
                flag = false;
            } else {
                break;
            }

        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 7, 0};
        BUbbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
