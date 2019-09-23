package com.ujiuye.crmpro.project.service;

import java.util.List;

import com.ujiuye.crmpro.project.pojo.Attachment;

public interface AttachmentService {

	int countByProFk(int pro_fk);
	
	List<Attachment> list(String name);
	
	boolean save(Attachment attachment);
	
	Attachment getById(int id);
	
	List<Attachment> listByType(int type);
}
