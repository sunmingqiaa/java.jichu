package sort_demo.demo;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int key = arr[left];
        int i = left;
        int tmp = 0;
        while (true) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <key) {
                left++;
            }
            if (left < right) {
                tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            } else {
                break;
            }
        }
        tmp = arr[right];
        arr[right] = arr[i];
        arr[i] = tmp;
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 2, 7, 3};
        int left = 0;
        int right = nums.length - 1;
        QuickSort.sort(nums, left, right);
        System.out.println(Arrays.toString(nums));
    }

}
