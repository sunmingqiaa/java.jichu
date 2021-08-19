package sort_demo;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] nums) {
        int[] tmp = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        /*int[] copy = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            copy[i]=nums[i];

        }*/
        sort(nums, left, right,tmp);

    }

    private static void sort(int[] nums, int left, int right,int[]tmp) {

        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid,tmp);
        sort(nums, mid + 1, right,tmp);
        merge(nums, left, mid, right, tmp);
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        int p1 = left;
        int p2 = mid + 1;
        for (int j = left; j <= right; j++) {
            if (p1 == mid + 1) {
                nums[j] = tmp[p2];
                p2++;
            } else if (p2 == right + 1) {
                nums[j] = tmp[p1];
                p1++;
            } else if (tmp[p1] <= tmp[p2]) {
                nums[j] = tmp[p1];
                p1++;
            } else {
                nums[j] = tmp[p2];
                p2++;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 2, 7, 3};
        MergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
