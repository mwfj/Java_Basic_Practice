package mwfj.demo.dao;

import mwfj.demo.entities.User;

public interface UserDao {
	
	public User getUser(String loginName, String loginPassword) throws Exception;

}
