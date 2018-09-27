package HelloWorld;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.alibaba.boot.dubbo.EnableDubboAutoConfiguration;

@SpringBootApplication
@EnableCaching
@EnableDubboAutoConfiguration
public class Demo {

	public static void main(String[] args) {

		SpringApplication.run(Demo.class, args);

	}

	
	@Bean
	public Queue queue1() {
		return new ActiveMQQueue("queue1");
	}
	
	@Bean
	public Queue queue2() {
		return new ActiveMQQueue("queue2");
	}

}
