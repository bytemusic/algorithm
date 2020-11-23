package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
 *选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {101, 34, 119, 1};
        int[] array1 = new int[10];
        for (int i = 0; i < 10; i++) {
            array1[i] = (int) (Math.random() * 100);
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(array1));
        System.out.println("排序后");
        selectSort(array1);
        System.out.println(Arrays.toString(array1));
        //速度测试


//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String data1str = simpleDateFormat.format(date1);
//        System.out.println("排序前时间是" + data1str);
//        selectSort(array1);
//        Date date2 = new Date();
//        String date2str = simpleDateFormat.format(date2);
//        System.out.println("排序后时间是:" + date2str);


    }

    //选择排序
    public static void selectSort(int[] arr) {
        //使用循环解决
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }

            }
            //交换一下，将最小值放在arr[0]
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

    }
}
