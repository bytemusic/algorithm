package search;

/**
 * @ClassName BisectionSearch
 * @Description TODO
 * @Author liuyubo
 * @Date 20-11-22
 **/
public class BisectionSearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int target = 5;
        int start = 0;
        int end = array.length;
        int mid = (start + end) / 2;
        while (array[mid] != target && end > start) {
            if (array[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) /2;
        }
        if (array[mid] == target) {
            System.out.println("找到目标值");
        }
     }
}
