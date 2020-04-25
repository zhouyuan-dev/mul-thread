package mul.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author: xingchen
 * @ClassName: WorkerThread
 * @Package: mul.thread
 * @Date: 2020/4/2114:10
 * @Description:
 */
public class WorkerThread {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        int num = 10;
        for (int i = 0; i < 10; i++) {
            new WorkThread(semaphore, i).start();
        }
    }

    static class WorkThread extends Thread {
        Semaphore semaphore;
        int num;

        WorkThread(Semaphore semaphore, int num) {
            this.semaphore = semaphore;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(num + "号工人获取机器,开始工作");
                Thread.sleep(2000);
                System.out.println(num + "号工人开始休息");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
