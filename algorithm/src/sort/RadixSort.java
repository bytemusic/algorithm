package sort;

import org.jetbrains.annotations.NotNull;

/**
 * @ClassName RadixSort
 * @Description TODO
 * @Author liuyubo
 * @Date 20-11-22
 **/
public class RadixSort {
    public static void main(String[] args) {
        int arr[] ={53,3,542,748,14,214};
    }
    public static void radixSort(@NotNull int[] arr) {
        //第一轮
        //定义一个二维数组，表示10个桶,每个桶就是一个一维数组
        //为了防止栈溢出，每个一维数组的大小都是arr.length
        int[][] bucket = new int[10][arr.length];
        //定义一维数组记录每个桶每次放入的数据个数
        int[] bucketElementCount = new int[10];
        //第一轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[j] %10;
            //放入到对应桶中
//            bucket[digitOfElement][bucketElementCount[digitOfElement]] == arr[j];
        }
        int index = 0;

    }
}
