package mul.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xingchen
 * @ClassName: ThreadLocalTests
 * @Package: mul.thread
 * @Date: 2020/4/2221:06
 * @Description:
 */
public class ThreadLocalTests {
    static ExecutorService service = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws Exception {
        ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
        threadLocal.set("wzzz");
        System.out.println(Thread.currentThread().getName());
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName().concat("->" + threadLocal.get()));
            }
        };
        TtlRunnable runnable = TtlRunnable.get(runnable1);
        service.execute(runnable);

        Thread.sleep(2000);
        threadLocal.set("zxy");
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName().concat("->" + threadLocal.get()));
            }
        };
        TtlRunnable runnable3 = TtlRunnable.get(runnable2);

        service.execute(runnable3);
        service.shutdown();
    }
}

