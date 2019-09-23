package com.ujiuye.crmpro.forum.service;

import java.util.List;

import com.ujiuye.crmpro.forum.pojo.Forumpost;

public interface ForumpostService {
	
	List<Forumpost> list(int forumsort_kf);
	
	Forumpost getById(int id);
	
	boolean updateClickById(int id);
	
	boolean updateCommentById(int id);
	
	boolean save(Forumpost forumpost);
}
