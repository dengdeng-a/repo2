package com.ServiceNode.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceNode.bean.User;
import com.ServiceNode.bean.UserExample;
import com.ServiceNode.bean.UserExample.Criteria;
import com.ServiceNode.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	/*
	 * (non-Javadoc)
	 * @see com.ServiceNode.Service.UserService1#RegisterLogin(java.lang.String, java.lang.String)
	 * 用户注册
	 */
	@Override
	public void RegisterLogin(User user) {
		userMapper.insertSelective(user);
	}

	
	/*
	 * 检验用户名是否可用
	 * true:可用   false：不可用
	 */
	@Override
	public boolean checkuser(String uname) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUnameEqualTo(uname);
		long count = userMapper.countByExample(example);
		return count==0;
	}


	@Override
	public User LoginCheck(String uname,String password) {
		User user = userMapper.selectByUname(uname);
		System.out.println(user);
		if(user != null && user.getPassword().equals(password)){
			return user;
		}
		return null;
	}
}
