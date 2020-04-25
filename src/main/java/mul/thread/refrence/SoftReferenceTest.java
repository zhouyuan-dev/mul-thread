package mul.thread.refrence;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * @Author: xingchen
 * @ClassName: NormalRefrence
 * @Package: mul.thread.refrence
 * @Date: 2020/4/25 17:19
 * @Description:
 */
public class SoftReferenceTest {
    /**
     * 软引用：当内存不足的时候，会回收的垃圾
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        SoftReference m = new SoftReference(new byte[1024 * 1024 * 10]);

        System.out.println(m.get());

        SoftReference m1 = new SoftReference(new byte[1024 * 1024 * 10]);

        System.out.println(m.get());
        System.out.println(m1.get());
    }
}
