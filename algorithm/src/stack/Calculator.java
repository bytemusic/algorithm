package stack;

public class Calculator {
    public static void main(String[] args) {
        //
        String expression = "3+2*6-2";
        //创建数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(5);
        ArrayStack2 operStack = new ArrayStack2(5);
        //定义相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        //while循环扫描
        while(true) {
            //依次得到expression每个字符
            ch = expression.substring(index,index+1).charAt(0);
            //
        }
    }
}

//先创建一个栈
class                                      ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//top表示栈顶，初始值为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//初始化栈
    }

    //增加一个方法，可以返回当前栈顶的值
    public int peek() {
        return stack[top];
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
    //返回运算符优先级，数字越大优先级越高
    public int priority(int oper) {
        if(oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;//假设只有+，-，*，/
        }

    }
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '*';
    }
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            default:
                break;
        }
        return res;
    }

}
