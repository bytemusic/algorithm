package search;

/**
 * @ClassName SeqSearch
 * @Description 线性查找
 * @Author liuyubo
 * @Date 20-11-23
 **/
public class SeqSearch {
    public static void main(String[] args) {

        int[] arr = {13,45,67,89,94};
        int index = 0;
        index = seqSearch(arr,89);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.printf("找到了，下标为 %d",index);
        }
    }

    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
