package com.ujiuye.crmpro.benchmarking.mapper;

import com.ujiuye.crmpro.benchmarking.pojo.Indexvalue;
import com.ujiuye.crmpro.benchmarking.pojo.IndexvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexvalueMapper {
    int countByExample(IndexvalueExample example);

    int deleteByExample(IndexvalueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Indexvalue record);

    int insertSelective(Indexvalue record);

    List<Indexvalue> selectByExample(IndexvalueExample example);

    Indexvalue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Indexvalue record, @Param("example") IndexvalueExample example);

    int updateByExample(@Param("record") Indexvalue record, @Param("example") IndexvalueExample example);

    int updateByPrimaryKeySelective(Indexvalue record);

    int updateByPrimaryKey(Indexvalue record);
}