package com.ujiuye.crmpro.employee.mapper;

import com.ujiuye.crmpro.employee.pojo.Depatment;
import com.ujiuye.crmpro.employee.pojo.DepatmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepatmentMapper {
    int countByExample(DepatmentExample example);

    int deleteByExample(DepatmentExample example);

    int deleteByPrimaryKey(Integer deptno);

    int insert(Depatment record);

    int insertSelective(Depatment record);

    List<Depatment> selectByExample(DepatmentExample example);

    Depatment selectByPrimaryKey(Integer deptno);

    int updateByExampleSelective(@Param("record") Depatment record, @Param("example") DepatmentExample example);

    int updateByExample(@Param("record") Depatment record, @Param("example") DepatmentExample example);

    int updateByPrimaryKeySelective(Depatment record);

    int updateByPrimaryKey(Depatment record);
}