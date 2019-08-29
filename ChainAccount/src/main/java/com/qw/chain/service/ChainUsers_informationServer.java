package com.qw.chain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qw.chain.bean.ChainUsers_information;
import com.qw.chain.bean.ChainUsers_types;
import com.qw.chain.dao.ChainUsers_typesMapper;
import com.qw.chain.dao.Chainusers_informationMapper;

@Service
public class ChainUsers_informationServer {
	
	
		@Autowired
		private Chainusers_informationMapper inforMapper;
		
		@Autowired
		private ChainUsers_typesMapper chainUsers_typesMapper; 


		public ChainUsers_information checkLogin(String c_usersinfor_telphone, String password) {
				
			ChainUsers_information chaininfor = inforMapper.findByUserPhone(c_usersinfor_telphone);
				System.out.println(chaininfor);
				if(chaininfor != null && chaininfor.getC_usersinfor_password().equals(password)){
				
					return chaininfor;
				}
				return null;
		}
		/*
		 * 注册
		 */
		public int resgistUsers(ChainUsers_information chainUsers_information) {
				
			int result = inforMapper.registUsersInfo(chainUsers_information);
				System.out.println("注册对象是："+result);
				return result;
		}

		/*
		 * 登录验证手机号码
		 */
		public ChainUsers_information getUsersByPhone(ChainUsers_information cusers) {
			// TODO Auto-generated method stub
			return inforMapper.selectuserbyuphone(cusers);
		}
		/*
		 * 登录验证密码
		 */
		public ChainUsers_information getUserspasssByUPass(ChainUsers_information cusers) {
			// TODO Auto-generated method stub
			return inforMapper.selectupassByupass(cusers);
		}
		/*
		 * 注册验证昵称
		 */
		public ChainUsers_information getUsersByName(ChainUsers_information cusers) {
			// TODO Auto-generated method stub
			return inforMapper.selectuserbyuname(cusers);
		}
		/*
		 * 注册验证手机号码
		 */
		public ChainUsers_information selectuserbyregistuphone(ChainUsers_information cusers) {
			// TODO Auto-generated method stub
			return inforMapper.selectuserbyregistuphone(cusers);
		}
		/*
		 * 注册验证密码
		 */
		public ChainUsers_information selectuserbyregistupass(ChainUsers_information cusers) {
			// TODO Auto-generated method stub
			return inforMapper.selectuserbyregistupass(cusers);
		}
		
		
		
		
		
		/*
		 * 登录之后查看个人信息
		 */
		public ChainUsers_information selectOneById(int uid) {
			return inforMapper.selectOneById(uid);
		}

		/*
		 * 查询类型信息
		 */
		public List<ChainUsers_types> selectTypes() {
			return chainUsers_typesMapper.selectTypes();
		}

		/*
		 * 修改信息
		 */
		public void updateUser(ChainUsers_information information) {
			inforMapper.updateUser(information);
			
		}

		/*
		 * 修改头像
		 */
		public void changeUploadImg(ChainUsers_information chainUsers_information) {
			inforMapper.changeUploadImg(chainUsers_information);	
		}
		/*
		 * 修改密码
		 */
		public void changepwd(ChainUsers_information information) {
			inforMapper.changepwd(information);
		}

}
