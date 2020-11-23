package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr1 = {-9,78,0,23,-256,70,-1,900,6798};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() *100);
        }
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left, int right) {
        int l = left;//左索引下标
        int r = right;//右索引下标
        //pivot中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //如果右边索引大于左边索引
        //比pivot值小放到左边，比pivot值大放到右边
        while(l < r) {
            //在pivot的左边一直找，直到找到大于等于pivot的值，才退出
            while(arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，直到找到小于等于pivot的值，才退出
            while(arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r,说明pivot左边全部小于等于pivot
            if(l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //交换完后，发现ar[l] == pivot,前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现arr[r] == pivot,右移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l == r,必须l++,r-- ,否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort(arr,left,r);
        }
        //向右递归
        if(right > l) {
            quickSort(arr,l,right);
        }
    }
}
