package sort;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @ClassName QuickSortDemo
 * @Description 快速排序
 * @Author liuyubo
 * @Date 20-11-22
 **/
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,2,8,1,9,5,4,6,10};
        sort(arr,0,arr.length-1);
        System.out.println("最后结果：");
        print(arr);
    }
    public static void sort(int[] arr, int leftBound, int rightBound) {
        if(leftBound >= rightBound) return;
        partition(arr,leftBound,rightBound);
    }
    static void partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while(left < right) {
            while(left < right && arr[left] <= pivot) left ++;
            while(left < right && arr[right] >= pivot) right--;
            System.out.println("交换前 left:" +left+ "right:" +right );
            if(left < right) swap(arr,left,right);
            System.out.println("循环中：");
            print(arr);
            System.out.println();
        }
        swap(arr,left,rightBound);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
