package sort_demo;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Integer[] nums = {5,2,6,1};
        Integer[] counts = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j ] > nums[j+1]) {
                    count++;
                }
            }
            counts[i] = count;

        }
        System.out.println(Arrays.toString(counts));
    }
}
