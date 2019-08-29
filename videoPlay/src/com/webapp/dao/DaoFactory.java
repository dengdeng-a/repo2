package com.webapp.dao;
import com.webapp.dao.MediaDapImpl;

/**
 *
 *  DaoFactory.java    
 *
 *  @version ： 1.1
 *  
 *  @author  ： 苏若年    <a href="mailto:DennisIT@163.com">发送邮件</a>
 *    
 *  @since     ： 1.0        创建时间:    2013-2-07        下午02:18:51
 *     
 *  TODO     :    class DaoFactory.java is used for ...
 *
 */
public class DaoFactory { //工厂模式,生产Dao对象,面向接口编程,返回实现业务接口定义的对象
    
    private static DaoFactory daoFactory = new DaoFactory();
    
    //单例设计模式, 私有构造,对外提供获取创建的对象的唯一接口,
    private DaoFactory(){
        
    }
    
    public static DaoFactory getInstance(){
        return daoFactory;
    }
    
    public static MediaDao getMediaDao(){
        return (MediaDao) new MediaDapImpl();
    }

}