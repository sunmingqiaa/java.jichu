package leetcode.sort.数组相对排序;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @author: smq
     * @date: 2021/8/26
     */
    /*问题描述：
    给定两个数组，arr1 和arr2，arr2中的元素各不相同，arr2 中的每个元素都出现在arr1中
     对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
    * */
    /*思路
    1、创建一个和arr1一样的tmp[],将arr1的拷贝到tmp[]
    2、将tmp[]按升序排序
    3、遍历arr2，将arr2对应的元素在arr[1]中遍历找到并桉顺序放到tmp[]

    输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    输出：[2,2,2,1,4,3,3,9,6,7,19]
    * */
    public static void soulute(int[] arr1, int[] arr2) {
        int[] tmp = new int[arr1.length];
        Arrays.sort(tmp);
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    tmp[index] = arr1[j];
                    index++;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!Arrays.toString(arr2).contains(String.valueOf(arr1[i]))) {
                list.add(arr1[i]);
            }
        }
//        将tmp中的数据copy到arr1
        for (int i = 0; i < tmp.length; i++) {
            arr1[i] = tmp[i];
        }
//        将list中的数据放到arr1
        int i = 0;
        int[] tmp2 = new int[list.size()];
        for (Integer integer : list) {
            tmp2[i] = integer;
            i++;
        }
        Arrays.sort(tmp2);
        i = 1;
        for (int j = tmp2.length - 1; j >= 0; j--) {
            arr1[arr1.length - i] = tmp2[j];
            i++;

        }
    }

    public static void main(String[] args) {
//        [26,21,11,20,50,34,1,18]
//[21,11,26,20]
        int[] arr1 = {26,21,11,20,50,34,1,18};
        int[] arr2 = {21,11,26,20};
        soulute(arr1, arr2);
        System.out.println(Arrays.toString(arr1));

    }
}
