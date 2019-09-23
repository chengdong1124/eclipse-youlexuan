package com.ujiuye.crmpro.forum.mapper;

import com.ujiuye.crmpro.forum.pojo.Forumpost;
import com.ujiuye.crmpro.forum.pojo.ForumpostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumpostMapper {
    int countByExample(ForumpostExample example);

    int deleteByExample(ForumpostExample example);

    int deleteByPrimaryKey(Integer forumid);

    int insert(Forumpost record);

    int insertSelective(Forumpost record);

    List<Forumpost> selectByExample(ForumpostExample example);

    Forumpost selectByPrimaryKey(Integer forumid);

    int updateByExampleSelective(@Param("record") Forumpost record, @Param("example") ForumpostExample example);

    int updateByExample(@Param("record") Forumpost record, @Param("example") ForumpostExample example);

    int updateByPrimaryKeySelective(Forumpost record);

    int updateByPrimaryKey(Forumpost record);
    
    int updateClickById(int id);
	
    int updateCommentById(int id);
}














