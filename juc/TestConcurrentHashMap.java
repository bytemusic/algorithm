package com.ale.juc;

/**
 * ConcurrentHashMap  采用锁分段机制，可以并行操作，提高效率
 * jkd 1.8 把ConcurrentHashMap 改为CAS
 * Collecton怎么使用，ConcurrentHashMap 就怎么使用
 * @Author YuboLiu
 * @Date 2020/9/8 15:52
 * @Version 1.0
 */
public class TestConcurrentHashMap {

}
class HelloThread implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}