package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int)(Math.random() * 80000);
        }
        System.out.println(Arrays.toString(array));
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1str = simpleDateFormat.format(date1);
        System.out.println("排序前时间是" + data1str);
        shellSort2(array);
        Date date2 = new Date();
        String date2str = simpleDateFormat.format(date2);
        System.out.println("排序后时间是:" + date2str);
    }

    //希尔排序交换法
    public static  void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            //将数据分组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组元素
                for (int j = i - gap; j >= 0 ; j-= gap) {
                    //如果当前元素大于加上步长后的元素
                    if(arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.printf("希尔排序第%d轮后：",gap);
//            System.out.println(Arrays.toString(arr));
        }
    }
    //希尔排序，移动法
    public static void shellSort2(int[] arr) {
        int temp = 0;
        //增量gap,并逐步的缩小增量
        for (int gap = arr.length / 2; gap < 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if(arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while，
                    arr[j] = temp;
                }
            }
        }
    }
}
