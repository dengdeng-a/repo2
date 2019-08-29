package com.ServiceNode.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceNode.Dao.UserDao;
import com.ServiceNode.bean.User;

@Service
public class UserServiceImpl implements UserService1{

	@Autowired
	private UserDao userDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.ServiceNode.Service.UserService1#RegisterLogin(java.lang.String, java.lang.String)
	 * ÓÃ»§×¢²á
	 */
	@Override
	public void RegisterLogin(User user) {
		userDao.registerByUsernameAndPassword(user.getUname(),user.getPassword(),user.getLevel());
	}

	
}
