package HelloWorld.Controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HelloWorld.pojo.User;

@RestController
@RequestMapping("queue")
public class QueueController {

	// 注入发送消息的对象
	@Autowired
	private JmsTemplate jmsTemplate;

	// 注入消息队列
	@Resource(name = "queue1")
	private Destination destination1;

	// 注入消息队列
	@Resource(name = "queue2")
	private Destination destination2;

	// 编写发送消息的方法
	@RequestMapping("send/queue1/{message}")
	public String send(@PathVariable String message) {
		this.jmsTemplate.convertAndSend(destination1, message);
		return "queue1消息发送成功!消息内容：" + message;
	}

	// 编写发送消息的方法
	@RequestMapping("sendObject/queue1")
	public String send3(@RequestParam Map<String, String> map) {
		this.jmsTemplate.convertAndSend(destination1, map);
		return "queue1消息发送一个map：" + map;
	}

	// 编写发送消息的方法
	@RequestMapping("send/queue2/{message}")
	public String send2(@PathVariable String message) {
		this.jmsTemplate.convertAndSend(destination2, message);
		return "queue2消息发送成功!消息内容：" + message;
	}

}
