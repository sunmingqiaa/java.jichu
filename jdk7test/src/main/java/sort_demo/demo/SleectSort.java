package sort_demo.demo;

import java.util.Arrays;

public class SleectSort {
    /**
     *@author: smq
     *@date: 2021/8/25
     */
/*
思路：选择排序
 1、第一次选出最小值放入arr[0]
 2、第二次选出从arr[1]开始的最小值，即在全局为第二小的值放入arr[1]
 3、一共需要排序次数为arr.length-1
 时间复杂度：O（n^2）
* */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 7, 0};
        SleectSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
