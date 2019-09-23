package com.ujiuye.crmpro.forum.service;

import java.util.List;

import com.ujiuye.crmpro.forum.pojo.Evaluate;

public interface EvaluateService {
	List<Evaluate> listByForumFk(int forum_Fk);
	boolean save(Evaluate evaluate);
	boolean remove(int id);
}
