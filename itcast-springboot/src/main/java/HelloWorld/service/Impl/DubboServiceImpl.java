package HelloWorld.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;

import HelloWorld.service.DubboService;
@Service
public class DubboServiceImpl implements DubboService {

	@Override
	public void test() {
		System.out.println("DubboTest");

	}

}
