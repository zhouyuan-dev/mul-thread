package mul.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xingchen
 * @ClassName: ThreadPoolTests
 * @Package: mul.thread
 * @Date: 2020/4/2210:01
 * @Description:
 */
public class ThreadPoolTests {
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();

    public static void main(String[] args) {
        Executors.newFixedThreadPool(1);
        /**
         * corePoolSize:核心线程池
         * maximunPoolSize:最大线程池
         * keepAliveTime:存活时间
         * 阻塞队列：
         *      ArrayBlockQueue
         *      LinkedBlockQueue
         *      SychonoseBlockQueue
         *      Pri
         * 线程工厂:
         * 任务拒绝策略
         *
         */

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 0,
                TimeUnit.MINUTES, new LinkedBlockingQueue<>(2), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executor.shutdown();
    }
}

class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    DefaultThreadFactory() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        namePrefix = "Test-" +
                poolNumber.getAndIncrement() +
                "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}