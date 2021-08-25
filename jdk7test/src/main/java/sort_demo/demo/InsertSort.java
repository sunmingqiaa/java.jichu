package sort_demo.demo;

import java.util.Arrays;

public class InsertSort {
    /**
     * @author: smq
     * @date: 2021/8/25
     */

    /*
     * 插入排序：
     * 1、第一步将arr[1]插入到前面的数组部分。将每次待插入数据之前的部分看成一个有序数组，
     * 2、以此类推，第n次循环将arr[n]插入到前面
     * 每次选出一个待插入值跟前面部分比较插入，由于前面是依次增大的有序数组，因此只要找到一个比待插入值小的值即可结束该值的比较循环
     * 时间复杂度为O（n^2）
     * */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                    index = j;
                } else {
                    break;
                }
            }
            arr[index] = tmp;
        }
    }

    public static void insertSort02(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
//          带插入值
            int insert = arr[i];
//            待插入值要插入的位置
            int insertIndex = i;//要插入的索引位置初始化假定为前一位
            while (insertIndex-1 >= 0 && insert < arr[insertIndex-1]) {
                arr[insertIndex ] = arr[insertIndex-1];
                insertIndex--;
            }
            arr[insertIndex ] = insert;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, -1, 7, 0};
        InsertSort.insertSort02(arr);
        System.out.println(Arrays.toString(arr));
    }
}
