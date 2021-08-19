package sort_demo;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partion(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);

    }

    private static int partion(int[] arr, int left, int right) {
        int key = arr[left];
        int i = left;

        while (true) {
            while (arr[right] >= key && left < right) {
                right--;
            }
            while (arr[left] <= key && left < right) {
                left++;
            }
            if (left < right) {
                exch(arr, left, right);
            } else {
                break;
            }

        }
        exch(arr, i, right);
        return right;


    }

    public static void exch(int[] a, int i1, int i2) {
        int tmp;
        tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 2, 7, 3};
        QuickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
