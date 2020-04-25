package mul.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CyclicBarrierTest {
    static Semaphore semaphore = new Semaphore(1);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            System.out.println("人到齐了，开始开会，下面由员工发表意见");
        }
    });

    //员工到达会议室
    static class EmpleoyeeThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "，到达会议室....");
            //员工到达会议室 count - 1
            try {
                cyclicBarrier.await();

                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "，开始发言………………");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new EmpleoyeeThread().start();
        }
    }
}