package mwfj.demo.spring.dao;

import mwfj.demo.spring.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void insertUser(User user) {

		System.out.println("--增加User--");

	}

	@Override
	public void deleteUser(User user) {
		
		System.out.println("--删除User--");

	}

}
