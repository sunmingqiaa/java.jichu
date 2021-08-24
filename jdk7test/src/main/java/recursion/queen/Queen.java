package recursion.queen;

public class Queen {
    public int[] arr;
    public int max;
    public int count;

    public Queen(int max) {
        this.max = max;
        arr = new int[max];
    }

    /**
     * @author: smq
     * @date: 2021/8/24
     */
    /*
    在8×8格的国际象棋上摆放8个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
    高斯认为有76种方案。1854年在柏林的象棋杂志上不同的作者发表了40种不同的解，后来有人用图论的方法解出92种结果
    * */
//    1、创建一个一维数组，索引代表行数，值代表列数
//    2、判断某个位置是否能放置皇后 遍历出第n个皇后之前的每个皇后是否都不冲突，冲突的判断标准
//       2.1、处于同一列：arr[n] == arr[i]
//       2.2、 处于斜线位置，根据三角形定理，如果两个直角边相等，即时处于同一斜线Math.abs(n-i)==Math.abs(arr[n]-arr[i])
//       2.3 处于同同一行，由于每个皇后的数组索引不一样，因此肯定不在同一行，不需要判断
//    3、通过循环的方法找每个皇后可能的位置，递归找第n个皇后可能的位置
    public void show() {
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + "  ");

        }
        System.out.println();
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public void check(int n) {
        if (n == max) {
            show();
            count ++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }

    }
}
