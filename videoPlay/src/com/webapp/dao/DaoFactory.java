package com.webapp.dao;
import com.webapp.dao.MediaDapImpl;

/**
 *
 *  DaoFactory.java    
 *
 *  @version �� 1.1
 *  
 *  @author  �� ������    <a href="mailto:DennisIT@163.com">�����ʼ�</a>
 *    
 *  @since     �� 1.0        ����ʱ��:    2013-2-07        ����02:18:51
 *     
 *  TODO     :    class DaoFactory.java is used for ...
 *
 */
public class DaoFactory { //����ģʽ,����Dao����,����ӿڱ��,����ʵ��ҵ��ӿڶ���Ķ���
    
    private static DaoFactory daoFactory = new DaoFactory();
    
    //�������ģʽ, ˽�й���,�����ṩ��ȡ�����Ķ����Ψһ�ӿ�,
    private DaoFactory(){
        
    }
    
    public static DaoFactory getInstance(){
        return daoFactory;
    }
    
    public static MediaDao getMediaDao(){
        return (MediaDao) new MediaDapImpl();
    }

}