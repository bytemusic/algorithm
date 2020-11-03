package com.ale.juc;

/**
 * @Author YuboLiu
 * @Date 2020/9/6 17:30
 * @Version 1.0
 *   i++的原子性问题：
 *   int i = 10;
 *   i = i ++;//结果：10
 *   原因：
 *   int temp = i;
 *   i = i + 1;
 *   i = temp;
 * volatile关键字
 * jdk 1.5 后 java.util.concurrent.atomic包提供了常用的原子变量:
 * 1.volatile 保存内存可见性
 * 2.CAS(Compare-And-Swap)算法保证数据原子性
 * CAS算法是硬件对于并发操作共享数据的支持
 * CAS包含3个操作数：
 * 内存值V
 * 预估值A
 * 更新值B
 * 当且仅当V==A时，V==B,否则，将不做任何操作
 */
public class TestVolatile {

}
class ThreadDemo implements Runnable{
    private boolean flag = false;
    public boolean isFlag() {

        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        flag = true;
    }
}
