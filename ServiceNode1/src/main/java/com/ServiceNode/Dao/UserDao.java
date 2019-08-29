package com.ServiceNode.Dao;



public interface UserDao {

	/**
     * ×¢²áÓÃ»§ºÍÃÜÂë
     */
    void registerByUsernameAndPassword(String username,String password,Integer level);
}
