package com.ujiuye.crmpro.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.project.mapper.AttachmentMapper;
import com.ujiuye.crmpro.project.pojo.Attachment;
import com.ujiuye.crmpro.project.pojo.AttachmentExample;
import com.ujiuye.crmpro.project.pojo.AttachmentExample.Criteria;

@Service
public class AttachmentServiceImpl implements AttachmentService{
	
	@Autowired
	private AttachmentMapper attachmentMapper;

	@Override
	public int countByProFk(int pro_fk) {
		AttachmentExample example=new AttachmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andProFkEqualTo(pro_fk);
		int result = attachmentMapper.countByExample(example);
		return result;
	}

	@Override
	public List<Attachment> list(String name) {
		AttachmentExample example=new AttachmentExample();
		Criteria criteria = example.createCriteria();
		if(name!=null && !name.equals("")) {
			criteria.andAttnameLike("%"+name+"%");
		}
		
		return attachmentMapper.selectByExample(example);
	}

	@Override
	public boolean save(Attachment attachment) {
		attachment.setAddtime(new Date());
		attachment.setUpdatetime(new Date());
		
		if(attachmentMapper.insertSelective(attachment)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Attachment getById(int id) {
		
		return attachmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Attachment> listByType(int type) {
		AttachmentExample example=new AttachmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		return attachmentMapper.selectByExample(example);
	}

}










