package mul.thread;

/**
 * @Author: xingchen
 * @ClassName: TThread
 * @Package: mul.thread
 * @Date: 2020/4/2119:32
 * @Description:
 */
public class TThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1 execute");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 execute");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T3 execute");
            }
        });


        t1.start();
        t3.start();
        t2.start();
    }
}


