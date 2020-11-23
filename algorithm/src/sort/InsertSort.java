package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
 *插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
        int[] array1 = new int[10];
        for (int i = 0; i < 10; i++) {
            array1[i] = (int) (Math.random() * 100);
        }
        System.out.println("原始数组");
        System.out.println(Arrays.toString(array1));

//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String data1str = simpleDateFormat.format(date1);
//        System.out.println("排序前时间是" + data1str);
          insertSort(array1);
//        Date date2 = new Date();
//        String date2str = simpleDateFormat.format(date2);
//        System.out.println("排序后时间是:" + date2str);
    }
    //插入排序
    public static void insertSort(int[] array) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < array.length ; i++) {
            //定以待插入的数
            //把变量定义到for循环外部，
            insertValue = array[i];
            insertIndex = i-1;//arr[1]前面这个数下标

            //给insertValue找插入的位置
            //保证下标不越界，待插入数还没有找到位置
            while(insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到了，insertIndex + 1
            array[insertIndex + 1] = insertValue;
            System.out.println("第" +i+"轮插入");
            System.out.println(Arrays.toString(array));
        }


    }
}
