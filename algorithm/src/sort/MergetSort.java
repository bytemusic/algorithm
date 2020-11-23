package sort;

import java.util.Arrays;
/*
 *归并排序
 */

public class MergetSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() *100);
        }
        int temp[] = new int[arr.length];
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));
    }
    //分+合方法
    public static void mergeSort(int[] arr, int left, int right,int[] temp){
        if(left < right) {
            int mid = (left + right)/2;
            //向左递归
            mergeSort(arr, left, mid, temp);
            //
            mergeSort(arr, mid + 1, right, temp);
            //没分解一次合并一次
            merge(arr,left,mid,right,temp);

        }
    }
    //合并方法
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;//初始化i，左边有序序列索引
        int j = mid + 1;//初始化j，右边有序序列索引
        int t = 0;//指向temp数组的当前索引
        //先把左右两边的数据按照规则填充到temp数组
        //直到有一边处理完
        while (i <= mid && j <= right) {
            //如果左边的有序数组小于右边的有序数组，则把左边的元素拷贝到temp
            //然后t++,
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                //反之，将右边有序序列的当前元素填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //2、把有剩余数组的一边的数据依次填充到temp,
        while(i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        //右边还有剩余元素
        while(j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //3、把temp数组拷贝到arr
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right) {//第一次合并tempLeft = 0
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
