package HelloWorld.service;

import java.util.List;

import HelloWorld.pojo.User;

public interface UserService {
	
	List<User> queryUserByName(String name);
	
	List<User> queryAll();
	List<User> queryUserByPage(Integer page, Integer rows);

}

