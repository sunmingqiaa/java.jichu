package leetcode.sort.救生艇问题;

import java.util.Arrays;

public class Solution {
    /**
     * @author: smq
     * @date: 2021/8/26
     */
   /*问题描述：第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
   * */
    /*分析：
    1、首先对数组进行排序
    2、利用双指针l，h 分别指向最轻和最重的人，如果arr[l]+arr[h]>limit,让h向左移动,反之，l++，h-- ，ans++
    * */
    public static int soulute(int[] arr, int limit) {

        int l = 0;
        int h = arr.length - 1;
        int ans = 0;
        Arrays.sort(arr);
        while (arr[l] + arr[h] > limit) {
            h--;
            ans++;
        }
        l++;
        h--;
        ans++;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int soulute = soulute(arr, 3);
        System.out.println(soulute);
    }
}
