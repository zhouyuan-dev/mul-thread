package mul.thread.refrence;

import java.io.IOException;

/**
 * @Author: xingchen
 * @ClassName: NormalRefrence
 * @Package: mul.thread.refrence
 * @Date: 2020/4/25 17:19
 * @Description:
 */
public class NormalRefrence {
    /**
     * 强应用：new JVM宁愿抛出异常，也不会回收的垃圾
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;

        System.gc();

        System.in.read();
    }
}
