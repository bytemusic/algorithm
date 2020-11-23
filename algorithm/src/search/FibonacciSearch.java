package search;

import java.util.Arrays;

/**
 * @ClassName FibonacciSearch
 * @Description 斐波那契查找
 * @Author liuyubo
 * @Date 20-11-23
 **/
public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
    }

    //需要先获取到一个斐波那契数列
    //递归和非递归都可以得到,这里使用非递归
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
    /*
     *a 数组，key需要查找值， return 返回下标，没有找到返回-1
     */
    //编写斐波那契查找算法
    public static int fibSearch(int[] a,int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契的下标
        int mid = 0;
        int f[] = fib();//获取到斐波那契数列
        //
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k] 值可能大于数组的长度，因此需要Arrays类，
        int[] temp = Arrays.copyOf(a,f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        //
        while (low <= high) {
            mid = low + f[k - 1] -1;
            if (key < temp[mid]) {//向数组左边查找
                high = mid - 1;
                //1.全部元素 = 前面的元素 + 后面元素
                //2.f[k] = f[k-1] + f[k-2]
                //因为前面有f[k
                k --;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {//找到了
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
