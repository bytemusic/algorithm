package queue;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        //创建一个队列
        //接收用户输入
        Queue queue = new Queue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列中");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.printf("取出数据%d\n",res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                    default:

                        break;
            }
        }
        System.out.println("程序退出～");
    }
}
class Queue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据

    //创建队列构造器
    public Queue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if(isFull()) {
            System.out.println("");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断是否为空
        if(isEmpty()) {
            //
            throw new RuntimeException("");
        }
        front++;//
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历
        if(isEmpty()) {
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("");
        }
        return arr[front + 1];
    }

}