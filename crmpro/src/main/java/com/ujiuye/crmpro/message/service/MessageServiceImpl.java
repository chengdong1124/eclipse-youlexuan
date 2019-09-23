package com.ujiuye.crmpro.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.message.mapper.MessageMapper;
import com.ujiuye.crmpro.message.pojo.Message;
import com.ujiuye.crmpro.message.pojo.MessageExample;
import com.ujiuye.crmpro.message.pojo.MessageExample.Criteria;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageMapper messageMapper;
	
	@Override
	public List<Message> listByType(int receive, String key, int type) {
		 MessageExample example = new MessageExample();
		 example.setOrderByClause("time desc");
		 Criteria criteria = example.createCriteria();
		 if(key != null && !key.equals("")) {
			 criteria.andTitleLike("%"+key+"%");
		 }
		 if(type<4) {
			 criteria.andTypeEqualTo(type);
		 }
		 criteria.andReceiveEqualTo(receive);
		return messageMapper.selectByExample(example);
	}

	@Override
	public Message getById(int id) {
		
		return messageMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean update(Message message) {
		if(messageMapper.updateByPrimaryKeySelective(message)>0) {
			return true;
		}
		return false;
	}

	@Override
	public int countByStatus(int receive, int status) {
		MessageExample example = new MessageExample();
		Criteria criteria = example.createCriteria();
		criteria.andReceiveEqualTo(receive);
		criteria.andStatusEqualTo(status);
		return messageMapper.countByExample(example);
	}

	@Override
	public boolean save(Message message) {
		if(messageMapper.insertSelective(message)>0) {
			return true;
		}
		return false;
	}


}



















