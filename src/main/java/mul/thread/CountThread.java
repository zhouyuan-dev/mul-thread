package mul.thread;

/**
 * @Author: xingchen
 * @ClassName: CountThread
 * @Package: mul.thread
 * @Date: 2020/4/2110:55
 * @Description:
 */
public class CountThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new Thread(new CountThread()).start();
        new Thread(new CountThread()).start();
    }
}
