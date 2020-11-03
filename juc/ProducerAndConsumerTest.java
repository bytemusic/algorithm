package com.ale.juc;

/**
 * @Description:TODO生产者 消费者 同步锁
 * 有问题
 * 采用等待唤醒机制
 * 设置延迟 1个为最大库存
 * 出现问题 程序无法停止，生产者产生的东西无法消费
 * 去掉else
 * 如果两个生产者两个消费者，出现问题，虚假唤醒
 * 将进货，卖货中if变为while,总是使用中循环
 * @Author YuboLiu
 * @Date 2020/9/14 19:32
 * @Version 1.0
 */
//public class ProducerAndConsumerTest {
//    public static void main(String[] args) {
//        Clerk clerk = new Clerk();
//        Productor productor = new Productor(clerk);
//        Consumer consumer = new Consumer(clerk);
//
//        new Thread(productor,"生产者1").start();
//        new Thread(consumer,"消费者1").start();
//
//        new Thread(productor,"生产者2").start();
//        new Thread(consumer,"消费者2").start();
//
//    }
//
//}
////店员
//class Clerk{
//    private int product = 0;
//    //进货
//    public synchronized void get(){
//        while (product >= 1){
//            System.out.println("仓库已满");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//            System.out.println(Thread.currentThread().getName() + ":" + ++product);
//
//            this.notifyAll();
//
//    }
//    //卖货
//    public synchronized void sell(){
//        while(product <= 0){
//            System.out.println("库存为零");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//            System.out.println(Thread.currentThread().getName() + ":" + --product);
//            this.notifyAll();
//
//    }
//}
////生产者
//class Productor implements Runnable{
//    private Clerk clerk;
//
//    public Productor(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clerk.get();
//        }
//
//    }
//}
////Comsumer
//class Consumer implements Runnable{
//    private Clerk clerk;
//
//    public Consumer(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clerk.sell();
//        }
//    }
//}
