package com.ServiceNode.Dao;



public interface UserDao {

	/**
     * ע���û�������
     */
    void registerByUsernameAndPassword(String username,String password,Integer level);
}
