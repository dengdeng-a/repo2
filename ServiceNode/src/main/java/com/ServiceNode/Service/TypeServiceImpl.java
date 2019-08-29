package com.ServiceNode.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceNode.bean.Type;
import com.ServiceNode.dao.ContextMapper;
import com.ServiceNode.dao.TypeMapper;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	private TypeMapper typeMapper;
	@Override
	public List<Type> getTypeAndContentAll() {
		
		return typeMapper.selectByExampleWithContext(null);
	}
	@Override
	public List<Type> getTypeName() {
		// TODO Auto-generated method stub
		return typeMapper.selectByExample(null);
	}
	
	
	@Override
	public List<Type> getInfoByTid(Integer tid) {
		// TODO Auto-generated method stub
		System.out.println("*********************"+tid);
		return typeMapper.selectByPrimaryKeyWithContext(tid);
	}

}
