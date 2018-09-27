package HelloWorld.service.Impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import HelloWorld.mapper.UserMapper;
import HelloWorld.pojo.User;
import HelloWorld.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;


	@Override
	@CacheEvict(value = "userCache", key = "'user.queryAll'")
	public List<User> queryUserByName(String name) {
		// 保存数据
		this.redisTemplate.boundValueOps("redis").set("Hello redis !");
		// 设置有效时间为100秒
		this.redisTemplate.boundValueOps("redis").expire(100l, TimeUnit.SECONDS);
		// 给value每次执行加一操作
		this.redisTemplate.boundValueOps("count").increment(1l);

		List<User> list = this.userMapper.queryUserByName(name);
		return list;
	}

	// 调用使用UserMapper.xml的Mapper
	@Override
	@Cacheable(value = "userCache", key = "'user.queryAll'")
	public List<User> queryAll() {
		System.out.println("查询全部");
		List<User> list = this.userMapper.queryAll();
		return list;
	}

	// 使用通用Mapper和分页助手
	@Override
	public List<User> queryUserByPage(Integer page, Integer rows) {
		String huancun = this.redisTemplate.boundValueOps("redis").get();
		System.out.println(huancun);
		
		// 设置分页
		PageHelper.startPage(page, rows);
		// 使用通用Mapper的方法进行查询所有数据
		List<User> list = this.userMapper.select(null);
		return list;
	}

}
