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
 * 测试dao层的工作
 * 推荐，spring的项目就是用spring的单元测试，可以自动注入我们需要的组件
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
	 * 测试deptmentMapper
	 * 
	 */
	@Test
	public void testCRUD(){
		System.out.println(typeMapper);
	
		//1.插入文件
		contextMapper.insertSelective(new Context(null, 2, 1, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/4.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 1, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/5.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 1, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/6.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 1, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/7.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 1, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/8.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 1, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/9.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 1, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/10.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 2, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/11.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 2, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/12.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 2, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/13.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
		contextMapper.insertSelective(new Context(null, 2, 2, "夜空中最亮的星", "D:/workspace1/ServiceNode/src/main/webapp/picture/14.jpg", "Oh 夜空中最亮的星Oh 请照亮我前行我祈祷拥有一颗透明的心灵和会流泪的眼睛给我再去相信的勇气Oh 越过谎言去拥抱你每当我找不到存在的意义每当我迷失在黑夜里Oh 夜空中最亮的星"));
	
	}
}
