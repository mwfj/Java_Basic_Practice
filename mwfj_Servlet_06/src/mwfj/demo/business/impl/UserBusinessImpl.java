package mwfj.demo.business.impl;

import mwfj.demo.business.UserBusiness;
import mwfj.demo.dao.UserDao;
import mwfj.demo.dao.impl.UserDaoImpl;
import mwfj.demo.entities.User;

public class UserBusinessImpl implements UserBusiness {

	private static boolean isNull(String str) {
		if (str == null || str.trim().equals("") || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 接口声明 实现类对象
	 */
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String loginName, String loginPassword) throws Exception {
		if (isNull(loginName)) {
			throw new BusinessException("登录名不能为空");
		}

		if (isNull(loginPassword)) {
			throw new BusinessException("登录密码不能为空");
		}

		if (loginPassword.length() < 4 || loginPassword.length() > 8) {
			throw new BusinessException("登录密码长度只能是4~8位");
		}

		return this.userDao.getUser(loginName, loginPassword);

	}

}
