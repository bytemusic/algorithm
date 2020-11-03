package com.ale.juc;

/**
 * @Description:printer one or two?
 * 1.two common methods,two thread.     print?  one two
 * 2.give getOne() the method sleep()   print?  one two
 * 3.add a common method getThree()     print?  three one two
 * 4.two common method,two object       print?  two one
 * 5.getOne the static method           print?  two one
 * 6.two static common method,one object print? one two
 * 7.one static,another not static.two object ? two one
 * 8.two static method,two object               one two
 * The essential of those :
 * 1.The lock of a non-static method is this,
 * and the lock of a static method is a Class instance
 * 2.Only one thread can hold the lock at a time
 * @Author YuboLiu
 * @Date 2020/9/14 21:18
 * @Version 1.0
 */
public class ThreadEightMonitor {
    public static void main(String[] args) {
        Number number1 = new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getTwo();
            }
        }).start();
    }

}
class Number{
    public synchronized void getOne(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }
    public synchronized void getTwo(){
        System.out.println("two");
    }
}