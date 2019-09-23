package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.common.PageResult;
import com.offcn.dao.TbContentMapper;
import com.offcn.pojo.TbContent;
import com.offcn.pojo.TbContentExample;
import com.offcn.pojo.TbContentExample.Criteria;
import com.offcn.service.ContentService;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbContent> findAll() {
		return contentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbContent> page = (Page<TbContent>) contentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbContent content) {
		contentMapper.insert(content);
		redisTemplate.boundHashOps("content").delete(content.getCategoryId());
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbContent content) {
		contentMapper.updateByPrimaryKey(content);
		redisTemplate.boundHashOps("content").delete(content.getCategoryId());
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbContent findOne(Long id) {
		return contentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			contentMapper.deleteByPrimaryKey(id);
			TbContent tbContent = contentMapper.selectByPrimaryKey(id);
			redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
		}
	}

	@Override
	public PageResult findPage(TbContent content, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();

		if (content != null) {
		}

		Page<TbContent> page = (Page<TbContent>) contentMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void updateStatus(long[] ids, String status) {
		for (long id : ids) {
			TbContent tbContent = contentMapper.selectByPrimaryKey(id);
			tbContent.setStatus(status);
			contentMapper.updateByPrimaryKeySelective(tbContent);
			//清空缓存
			redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
		}
	}

	@Override
	public List<TbContent> findContentById(long categoryId) {
		List<TbContent> contentList =(List<TbContent>)redisTemplate.boundHashOps("content").get(categoryId);
		if(contentList == null ) {
			TbContentExample example = new TbContentExample();
			Criteria criteria = example.createCriteria();
			criteria.andCategoryIdEqualTo(categoryId);
			criteria.andStatusEqualTo("0");
			List<TbContent> list = contentMapper.selectByExample(example);
			redisTemplate.boundHashOps("content").put(categoryId, list);
			return list;
		}else {
			System.out.println("获取缓存数据");
			return contentList;
		}
	}

}





