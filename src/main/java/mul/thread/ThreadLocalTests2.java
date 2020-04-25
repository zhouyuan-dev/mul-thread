package mul.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xingchen
 * @ClassName: ThreadLocalTests
 * @Package: mul.thread
 * @Date: 2020/4/2221:06
 * @Description:
 */
public class ThreadLocalTests2 {
    static ExecutorService service1 = Executors.newFixedThreadPool(1);
    static ExecutorService service = TtlExecutors.getTtlExecutorService(service1);

    public static void main(String[] args) throws Exception {
        ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
        threadLocal.set("wzzz");
        System.out.println(Thread.currentThread().getName());
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName().concat("->" + threadLocal.get()));
            }
        });
        Thread.sleep(2000);
        threadLocal.set("zxy");
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName().concat("->" + threadLocal.get()));
            }
        });
        service.shutdown();
    }
}

