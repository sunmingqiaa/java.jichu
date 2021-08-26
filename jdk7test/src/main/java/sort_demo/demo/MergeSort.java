package sort_demo.demo;

import java.util.Arrays;

public class MergeSort {


    public static void sort(int[] arr, int left, int right) {
//        1、先递归分，将数组一分为二，分而治之，知道分成每部分元素个数都是一个
        if (left>=right){
            return;
        }
        int mid = (left + right) / 2;
//        往左递归
        sort(arr, left, mid);
//        往右递归
        sort(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    private static void merge(int[] arr, int left, int right, int mid) {
        int l = left;
        int r = mid+1;
        int index = left;
        int[] tmp = new int[arr.length];
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tmp[index] = arr[l];
                l++;
            } else {
                tmp[index] = arr[r];
                r++;
            }
            index++;
        }
        while (l <= mid) {
            tmp[index] = arr[l];
            l++;
            index++;
        }
        while (r<=right) {
            tmp[index] = arr[r];
            r++;
            index++;
        }
//        将tmp数组copy到arr
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];

        }
        int []x={left,right};
        System.out.println(Arrays.toString(x));
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 2, 7, 3};
        int left = 0;
        int right = nums.length - 1;
        MergeSort.sort(nums, left, right);
        System.out.println(Arrays.toString(nums));
    }

}
