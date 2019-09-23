package com.ujiuye.crmpro.employee.mapper;

import com.ujiuye.crmpro.employee.pojo.Archives;
import com.ujiuye.crmpro.employee.pojo.ArchivesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchivesMapper {
    int countByExample(ArchivesExample example);

    int deleteByExample(ArchivesExample example);

    int deleteByPrimaryKey(String num);

    int insert(Archives record);

    int insertSelective(Archives record);

    List<Archives> selectByExample(ArchivesExample example);

    Archives selectByPrimaryKey(String num);

    int updateByExampleSelective(@Param("record") Archives record, @Param("example") ArchivesExample example);

    int updateByExample(@Param("record") Archives record, @Param("example") ArchivesExample example);

    int updateByPrimaryKeySelective(Archives record);

    int updateByPrimaryKey(Archives record);
    
    int saveAll(List<Archives> list);
}


















