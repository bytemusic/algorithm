package queue;
/*
 *环形队列
 */
public class CircularQueue {
    public static void main(String[] args) {

    }
}
class CircularArray {
    //
    private int maxSize;
    //
    private int front;
    //
    private int rear;
    private int[] arr;

    public  CircularArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    //
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //
    public boolean isEmpty() {
        return rear == front;
    }
}