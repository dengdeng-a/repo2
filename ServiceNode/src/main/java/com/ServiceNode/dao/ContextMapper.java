package com.ServiceNode.dao;

import com.ServiceNode.bean.Context;
import com.ServiceNode.bean.ContextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContextMapper {
    long countByExample(ContextExample example);

    int deleteByExample(ContextExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Context record);

    int insertSelective(Context record);

    List<Context> selectByExample(ContextExample example);

    Context selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Context record, @Param("example") ContextExample example);

    int updateByExample(@Param("record") Context record, @Param("example") ContextExample example);

    int updateByPrimaryKeySelective(Context record);

    int updateByPrimaryKey(Context record);


}