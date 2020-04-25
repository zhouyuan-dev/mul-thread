package mul.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: xingchen
 * @ClassName: ReentrantReadWriteLockTests
 * @Package: mul.thread
 * @Date: 2020/4/2210:24
 * @Description:
 */
public class ReentrantReadWriteLockTests {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.readLock();
    }
}
