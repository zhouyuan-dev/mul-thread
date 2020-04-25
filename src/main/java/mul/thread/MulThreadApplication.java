package mul.thread;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MulThreadApplication {
    public static void main(String[] args) {
        SpringApplication.run(MulThreadApplication.class, args);
    }

    private void producerMessage() throws MQClientException {
        MQProducer mqProducer = new DefaultMQProducer("", "");
        mqProducer.start();
    }
}
