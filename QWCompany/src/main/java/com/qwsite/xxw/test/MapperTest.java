package com.qwsite.xxw.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qwsite.xxw.bean.Admin;
import com.qwsite.xxw.bean.News;
import com.qwsite.xxw.dao.AdminMapper;
import com.qwsite.xxw.dao.NewsMapper;

/*
 * 测试dao层的工作
 * 推荐，spring的项目就是用spring的单元测试，可以自动注入我们需要的组件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

	
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	NewsMapper newsMapper;
	/*
	 * 测试admin
	 * 
	 */
	
	@Test
	public void testCRUD(){
		//adminMapper.insertSelective(new Admin(1001,"qwone",20181001));
		//newsMapper.insertSelective(new News(001,"区块链技术","目前，中国区块链产业正处于高速发展阶段，在全国有数千家企业和机构进军区块链领域，阿里巴巴、腾讯、Apple、微软等科技巨头纷纷进场。中国国务院已将区块链列入《“十三五”国家信息化规划》。此外，区块链技术正在衍生为新业态，成为发展的新动力，正推动着新一轮的商业模式变革，成为打造诚信社会体系的重要支撑，与此同时，各地政府积极从产业高度定位区块链技术，政策体系和监管框架逐渐发展完善。","20181008",null));
		//newsMapper.insertSelective(new News(002,"区块链技术","目前，中国区块链产业正处于高速发展阶段，在全国有数千家企业和机构进军区块链领域，阿里巴巴、腾讯、Apple、微软等科技巨头纷纷进场。中国国务院已将区块链列入《“十三五”国家信息化规划》。此外，区块链技术正在衍生为新业态，成为发展的新动力，正推动着新一轮的商业模式变革，成为打造诚信社会体系的重要支撑，与此同时，各地政府积极从产业高度定位区块链技术，政策体系和监管框架逐渐发展完善。","20181008",null));
		//newsMapper.insertSelective(new News(003,"区块链技术","目前，中国区块链产业正处于高速发展阶段，在全国有数千家企业和机构进军区块链领域，阿里巴巴、腾讯、Apple、微软等科技巨头纷纷进场。中国国务院已将区块链列入《“十三五”国家信息化规划》。此外，区块链技术正在衍生为新业态，成为发展的新动力，正推动着新一轮的商业模式变革，成为打造诚信社会体系的重要支撑，与此同时，各地政府积极从产业高度定位区块链技术，政策体系和监管框架逐渐发展完善。","20181008",null));
	}
}
