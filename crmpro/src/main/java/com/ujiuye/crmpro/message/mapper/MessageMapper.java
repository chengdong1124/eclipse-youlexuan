package com.ujiuye.crmpro.message.mapper;

import com.ujiuye.crmpro.message.pojo.Message;
import com.ujiuye.crmpro.message.pojo.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer msgid);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer msgid);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}