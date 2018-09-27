package HelloWorld.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Value("${name}")
	private String name;
	
	@Value("${url}")
	private String url;

	//分支上传测试
	@RequestMapping("info")
	public String info(){
		
		System.out.println(name);
		System.out.println(url);

		
		return "HelloWorld";
	}

}
