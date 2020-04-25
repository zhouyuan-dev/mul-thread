package mul.thread.refrence;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author: xingchen
 * @ClassName: NormalRefrence
 * @Package: mul.thread.refrence
 * @Date: 2020/4/25 17:19
 * @Description:
 */
public class PhReferenceTest {
    /**
     * 虚引用
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference m = new PhantomReference(new M(), queue);

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        Thread.sleep(1000);
    }
}
