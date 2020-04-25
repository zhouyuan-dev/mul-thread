package mul.thread.refrence;

import java.util.UUID;

/**
 * @Author: xingchen
 * @ClassName: M
 * @Package: mul.thread.refrence
 * @Date: 2020/4/25 17:18
 * @Description:
 */
public class M {
    /**
     * 垃圾回收的时候会调用此方法
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }

    public void test(Mi mi) {
        System.out.println(mi.getNext());
    }

    public static void main(String[] args) {
        M m = new M();
        m.test(() -> UUID.randomUUID().hashCode());
    }
}
