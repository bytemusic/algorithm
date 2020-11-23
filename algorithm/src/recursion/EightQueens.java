package recursion;

public class EightQueens {
    //先定义一个max,表示有多少皇后
    int max = 8;
    //定义一个数组array,保存皇后位置放置结果
    int[] array = new int[max];
    //一共有多少种放置方法
    static int count;
    //一共演算了多少次
    static int judgeCount = 0;
    public static void main(String[] args) {
        //测试
        EightQueens queens = new EightQueens();
        queens.check(0);
        System.out.printf("一共判断%d次",judgeCount);

    }

    //放置第n个皇后
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        //依次放置皇后
        for (int i = 0; i < max; i++) {
            //先把当前皇后，放在改行的第一列
            array[n] = i;
            //判断放置第n个皇后到i列，是否冲突
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
    //查看当前位置放置第n个皇后，是否和前面的皇后冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //Math.abs(n-i) == Math.abs(array[n] - array[i])表示是否在同以斜线上
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    //写一个方法，将皇后位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
