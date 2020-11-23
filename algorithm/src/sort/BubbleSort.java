package sort;

public class BubbleSort {
    public static void main(String[] args) {
        //随机生成8个随机数
        int[] array = new int[8];
        for (int i = 0; i < 8; i++) {
            array[i] = (int)(Math.random() * 8);
        }
        System.out.println("排序前：");
        for (int i = 0; i < 8; i++) {
            System.out.print(array[i]);
        }
        int temp = 0;
        System.out.println();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            System.out.print(array[i]);
        }

    }
}
