package leetcode.sort.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

public class Solution {
    /**
     *@author: smq
     *@date: 2021/8/26
     */
    /*问题描述：
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     如果数组中不存在目标值 target，返回[-1, -1]。
    进阶：
       你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
    示例 1：
    输入：nums = [5,7,7,8,8,10], target = 8
    输出：[3,4]
    * */
    public static int[] solute(int[]arr ,int target){
        int [] ans={-1,-1};
        int index=-1;
        int count=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==target){
                index=i;
                count++;
            }
        }
       if (count>0){
           ans[0]=index-count+1;
           ans[1]=index;
       }
        return ans;
    }

    public static void main(String[] args) {
        int []arr={5,7,7,8,8,10};
        int[] ans = Solution.solute(arr, 9);
        System.out.println(Arrays.toString(ans));
    }
}
