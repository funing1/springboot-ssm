package HelloWorld.Controller;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import HelloWorld.pojo.User;

@Component
public class Consumer {

	@JmsListener(destination = "queue1")
	public void readMessage3(Message message) throws Exception {
		if (message instanceof MapMessage) {
			MapMessage mm = (MapMessage) message;
			System.out.println("queue1接受到一个map：" + mm.getString("id"));
		}
		
		if (message instanceof TextMessage) {
			TextMessage mm = (TextMessage) message;
			System.out.println("queue1接受到一个字符串：" + mm.getText());
		}
	}

	@JmsListener(destination = "queue2")
	public void readMessage2(String text) {
		System.out.println("queue2接受到的消息是：" + text);
	}
}
