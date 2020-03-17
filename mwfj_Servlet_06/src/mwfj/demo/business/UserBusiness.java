package mwfj.demo.business;

import mwfj.demo.entities.User;

public interface UserBusiness {
	
	public User login(String loginName, String loginPassword) throws Exception;

}
