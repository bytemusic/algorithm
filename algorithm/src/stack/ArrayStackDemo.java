package stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop) {
            System.out.println("show：显示栈");
            System.out.println("exit:退出");
            System.out.println("push:添加");
            System.out.println("pop:出栈");
            System.out.println("请输入操作代码:");
            key = scanner.next();
            switch (key) {
                case"show":
                    stack.list();
                    break;
                case"push":
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    stack.push(value);
                    break;
                case"pop":
                    try{
                        int res = stack.pop();
                        System.out.printf("出站的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case"exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}
//定义一个ArrayStack表示栈
class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//top表示栈顶，初始值为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//初始化栈
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入站
    public void push(int value) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出站
    public int pop() {
        if(isEmpty()) {
            //运行时异常可以直接抛出,
            throw new RuntimeException();
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况.遍历时从栈顶开始显示
    public void list() {
        if(isEmpty()) {
            System.out.println("空栈");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d\nsho",i,stack[i]);
        }
    }
}