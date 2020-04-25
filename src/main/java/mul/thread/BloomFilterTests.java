package mul.thread;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import lombok.Data;

/**
 * @Author: xingchen
 * @ClassName: BloomFilterTests
 * @Package: mul.thread
 * @Date: 2020/4/2314:25
 * @Description:
 */
public class BloomFilterTests {
    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),
                1);

        bloomFilter.put("aaa");
        bloomFilter.put("bbb");

        boolean isContain = bloomFilter.mightContain("aaa");
        System.out.println(isContain);

        BloomFilter<Email> bloomFilter1 = BloomFilter.create((Funnel<Email>) (email, primitiveSink) -> primitiveSink.putString(email.toString(), Charsets.UTF_8), 100);

        bloomFilter1.put(new Email("aaa", "111111"));
        bloomFilter1.put(new Email("bbbb", "123456"));

        boolean isCon = bloomFilter1.mightContain(new Email("aaa", "1234"));

        System.out.println(isCon);
    }
}

@Data
class Email {
    private String userName;
    private String password;

    public Email(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
