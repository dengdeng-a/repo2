package com.ServiceNode.Test;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ServiceNode.bean.Context;
import com.ServiceNode.bean.Type;
import com.ServiceNode.dao.ContextMapper;
import com.ServiceNode.dao.TypeMapper;
import com.ServiceNode.dao.UserMapper;

/*
 * ����dao��Ĺ���
 * �Ƽ���spring����Ŀ������spring�ĵ�Ԫ���ԣ������Զ�ע��������Ҫ�����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	UserMapper usertMapper;
	
	@Autowired
	TypeMapper typeMapper;
	
	@Autowired
	ContextMapper contextMapper;

	@Autowired
	SqlSession sqlSession;
	/*
	 * ����deptmentMapper
	 * 
	 */
	@Test
	public void testCRUD(){
		System.out.println(typeMapper);
	
		//1.�����ļ�
		contextMapper.insertSelective(new Context(null, 2, 1, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/4.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 1, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/5.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 1, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/6.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 1, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/7.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 1, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/8.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 1, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/9.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 1, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/10.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 2, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/11.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 2, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/12.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 2, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/13.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
		contextMapper.insertSelective(new Context(null, 2, 2, "ҹ������������", "D:/workspace1/ServiceNode/src/main/webapp/picture/14.jpg", "Oh ҹ������������Oh ��������ǰ������ӵ��һ��͸��������ͻ�������۾�������ȥ���ŵ�����Oh Խ������ȥӵ����ÿ�����Ҳ������ڵ�����ÿ������ʧ�ں�ҹ��Oh ҹ������������"));
	
	}
}
