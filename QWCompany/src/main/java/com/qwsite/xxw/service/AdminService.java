package com.qwsite.xxw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwsite.xxw.bean.Admin;
import com.qwsite.xxw.dao.AdminMapper;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;

	public Admin checkLogin(String aname, Integer password) {
			
			Admin admin = adminMapper.findByUsername(aname);
			System.out.println(admin);
			if(admin != null && admin.getPassword().equals(password)){
			
				return admin;
			}
			return null;
	}
}
