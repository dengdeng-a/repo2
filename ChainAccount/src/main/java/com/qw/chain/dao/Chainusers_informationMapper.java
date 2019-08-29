package com.qw.chain.dao;

import com.qw.chain.bean.ChainUsers_information;

public interface Chainusers_informationMapper {
	public ChainUsers_information findByUserPhone(String c_usersinfor_name);
	
	public int registUsersInfo(ChainUsers_information chainUsers_information);
	public ChainUsers_information  selectuserbyuphone(ChainUsers_information chainUsers_information);
	public ChainUsers_information  selectuserbyregistuphone(ChainUsers_information chainUsers_information);
	public ChainUsers_information  selectuserbyregistupass(ChainUsers_information chainUsers_information);
	public ChainUsers_information  selectuserbyuname(ChainUsers_information chainUsers_information);
	public ChainUsers_information  selectupassByupass(ChainUsers_information chainUsers_information);/**/
	
	
	//登录之后通过id查看个人信息
		ChainUsers_information selectOneById(int uid);

		//修改个人信息
		void updateUser(ChainUsers_information information);

		//修改头像
		void changeUploadImg(ChainUsers_information chainUsers_information);

		//修改密码
		public void changepwd(ChainUsers_information information);
}
