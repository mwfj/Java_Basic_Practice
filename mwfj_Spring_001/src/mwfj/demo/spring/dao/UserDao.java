package mwfj.demo.spring.dao;

import mwfj.demo.spring.entities.User;

public interface UserDao {
	
	public void insertUser(User user);
	
	public void deleteUser(User user);

}
