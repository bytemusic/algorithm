package com.ale.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于解决多线程安全问题的方式：
 * synchronized
 * 1.同步代码块
 * 2.同步方法
 * jdk 1.5以后
 * 3.同步锁Lock
 * 注意：这是一个显示锁，需要通过lock()方法上锁，unlock()方法释放锁
 * @Author YuboLiu
 * @Date 2020/9/11 14:35
 * @Version 1.0
 */
public class LuckTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"1号窗口").start();
    }

}
class Ticket implements Runnable{
    private int tickets = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            lock.lock();
            try{
                if(tickets > 0){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "开始售票,余票:" + --tickets);
                }
            }finally {
                lock.unlock();
            }



        }
    }
}