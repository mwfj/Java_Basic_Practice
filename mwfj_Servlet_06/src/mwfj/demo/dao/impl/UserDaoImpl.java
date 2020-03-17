package mwfj.demo.dao.impl;

import mwfj.demo.dao.UserDao;
import mwfj.demo.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(String loginName, String loginPassword)
			throws Exception {
		User user = null;
		if ((loginName.trim().equals("tom") && loginPassword.trim().equals(
				"1234"))
				|| (loginName.trim().equals("jack") && loginPassword.trim()
						.equals("1234"))) {
			user = new User(loginName, loginPassword);
			return user;
		}
		return null;
	}

}
