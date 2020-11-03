package com.ale.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:TODO生产者 消费者 同步锁
 * 用lock解决
 * 初始化对象Condition
 * 将wait,notify,notifyAll改为await,signal,signalAll
 * @Author YuboLiu
 * @Date 2020/9/14 19:32
 * @Version 1.0
 */
public class ProducerAndConsumerLockTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(productor,"生产者1").start();
        new Thread(consumer,"消费者1").start();

        new Thread(productor,"生产者2").start();
        new Thread(consumer,"消费者2").start();

    }

}
//店员
class Clerk{
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //进货
    public void get(){
        lock.lock();
        try{
            while (product >= 1){
                System.out.println("仓库已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
    //卖货
    public synchronized void sell(){
        lock.lock();
        try{
            while(product <= 0){
                System.out.println("库存为零");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            condition.signalAll();

        }finally {
            lock.unlock();
        }

    }
}
//生产者
class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }

    }
}
//Comsumer
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.sell();
        }
    }
}
