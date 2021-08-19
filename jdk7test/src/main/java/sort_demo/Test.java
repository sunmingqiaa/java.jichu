package sort_demo;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 33; i++) {
            Set<Integer> hashset = new HashSet();
            Random random = new Random();
            while (true) {
                hashset.add(random.nextInt(33) + 1);
                //如果容量等于6  跳出循环
                if (hashset.size() == 6) {
                    break;
                }
            }
            System.out.print("红球：");
            int[] ints = new int[6];
//           转成数组
            Iterator<Integer> iterator = hashset.iterator();
            for (int j = 0; j < 6; j++) {
                ints[j] = iterator.next();
            }
            QuickSort.sort(ints);
            System.out.print(Arrays.toString(ints) + " ");
            System.out.println("蓝球：" + (random.nextInt(16) + 1));
        }
    }
}

