package mul.thread.refrence;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Author: xingchen
 * @ClassName: NormalRefrence
 * @Package: mul.thread.refrence
 * @Date: 2020/4/25 17:19
 * @Description:
 */
public class WeakReferenceTest {
    /**
     * 须引用：只要垃圾回收器看见就会回收
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        WeakReference m = new WeakReference(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        Thread.sleep(1000);
    }
}
