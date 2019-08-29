package com.ServiceNode.Service;

import com.ServiceNode.bean.User;

public interface UserService {

	void RegisterLogin(User user);

	boolean checkuser(String uname);

	User LoginCheck(String uname, String password);

	
}
