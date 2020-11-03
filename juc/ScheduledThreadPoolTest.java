package com.ale.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Description:TODO
 * 线程调度
 * @Author YuboLiu
 * @Date 2020/9/15 18:34
 * @Version 1.0
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future<Integer> result =  pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //100以内的随机数
                    int m = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + ":" + m);
                    return m;
                }
            },1,TimeUnit.SECONDS);
            System.out.println(result.get());
            //放在这里是错的
//            pool.shutdown();
        }
        //shutdown要放在外面
        pool.shutdown();

    }
}
