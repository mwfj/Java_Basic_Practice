package mwfj.demo.spring.service;

public interface UserService {
	
	public void newUser(String loginName, String loginPassword);
	
	public void removeUser(String id);

}
