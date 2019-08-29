package com.ServiceNode.Service;

import java.util.List;

import com.ServiceNode.bean.Type;

public interface TypeService {

	List<Type> getTypeAndContentAll();

	List<Type> getTypeName();

	List<Type> getInfoByTid(Integer tid);

}
