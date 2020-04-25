package mul.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xingchen
 * @ClassName: ThreadMethod
 * @Package: mul.thread
 * @Date: 2020/4/2111:12
 * @Description:
 */
public class ThreadMethod {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        MyThread myThread1 = new MyThread();
        myThread1.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "开始执行！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕！");
            } finally {
                lock.unlock();
            }
        }
    }
}
