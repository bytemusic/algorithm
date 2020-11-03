package com.ale.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable有闭锁功能
 * 创建线程的方式三：实现Callable接口
 * @Author YuboLiu
 * @Date 2020/9/9 10:45
 * @Version 1.0
 */
public class CallableTest {
    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        //执行Callable方式，需要FutureTask实现类的支持，用于接收数据，
        FutureTask<Integer> result = new FutureTask<>(threadDemo1);
        new Thread(result).start();
        //接收线程运算后的结果
        try {
            Integer sum = result.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}

/**有返回值，并且可以抛出异常
 *相较于Runnable,Callable
 */
class ThreadDemo1 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}