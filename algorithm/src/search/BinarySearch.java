package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BinarySearch
 * @Description TODO
 * @Author liuyubo
 * @Date 20-11-22
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11,13,13,15,17,19,35};
        System.out.println("原始数组");
        System.out.println(Arrays.toString(arr));
        List<Integer> resIndexList = new ArrayList<>();
        resIndexList = binarySearch2(arr,0,arr.length - 1,13);
        System.out.println("查找数的索引是"+resIndexList);
    }
    /*
     *只能查找一个
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) /2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch(arr,mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        }
        return mid;
    }
    /*
     *当待查找的数有几个时，怎么解决？
     * 在找到mid索引值时，不要立马返回
     * 向mid索引值左边扫描，将所有满足条件的元素下标，加入到集合ArrayList
     * 向mid索引值右边扫描，将所有满足条件的元素下标，加入到集合ArrayList
     * 最后返回ArrayList
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if(left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) /2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch2(arr,mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while(true) {
                if(temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while(true) {
                if(temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }

    }
}
