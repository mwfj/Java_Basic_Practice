package mwfj.demo.spring.service;

import mwfj.demo.spring.dao.UserDao;
import mwfj.demo.spring.entities.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	
	public UserServiceImpl() {}

	/**
	 * 构造注入
	 * @param userDao
	 */
	public UserServiceImpl(UserDao userDao) {
		System.out.println("--构造注入--");
		this.userDao = userDao;
	}
	
	/**
	 * setter 注入
	 * @param userDao
	 */
	public void setUserDao(UserDao userDao) {
		System.out.println("--setter注入--");
		this.userDao = userDao;
	}

	@Override
	public void newUser(String loginName, String loginPassword) {
		User user = new User();
		user.setLoginName(loginName);
		user.setLoginPassword(loginPassword);
		this.userDao.insertUser(user);
		System.out.println("--业务层NewUser调用--");
	}

	@Override
	public void removeUser(String id) {
		
		
	}

}
