package mul.thread.base;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @Author: xingchen
 * @ClassName: FirstTests1
 * @Package: mul.thread.base
 * @Date: 2020/4/24 20:43
 * @Description:
 */
public class FirstTests {
    public static void main(String[] args) throws Exception {
        Thread thread2 = new NameThread();
        /**
         * 创建线程的方法
         */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1");
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        /**
         * 2
         */
        thread2.start();
        thread1.start();
    }

    static class NameThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread 2");
        }
    }

    /**
     * 带有返回值的线程
     */
    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return UUID.randomUUID().toString();
        }
    }
}
