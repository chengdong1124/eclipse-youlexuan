package com.ujiuye.crmpro.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.message.mapper.NoticeMapper;
import com.ujiuye.crmpro.message.pojo.Notice;
import com.ujiuye.crmpro.message.pojo.NoticeExample;
import com.ujiuye.crmpro.message.pojo.NoticeExample.Criteria;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public boolean save(Notice notice) {
		try {
			if (noticeMapper.insertSelective(notice) > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Notice> list(String key) {
		NoticeExample example = new NoticeExample();
		Criteria createCriteria = example.createCriteria();
		return noticeMapper.selectByExample(example);
	}

	@Override
	public Notice getById(int id) {
		Notice notice = noticeMapper.selectByPrimaryKey(id);
		return notice;
	}

}































