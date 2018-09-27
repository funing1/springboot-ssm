package HelloWorld.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import HelloWorld.pojo.User;

@Mapper
public interface UserMapper extends com.github.abel533.mapper.Mapper<User> {

	@Select("select * from user where name like '%${value}%'")
	public List<User> queryUserByName(String name);

	// 使用UserMapper.xml配置文件
	public List<User> queryAll();

}
