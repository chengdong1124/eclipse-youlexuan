package com.offcn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.common.PageResult;
import com.offcn.common.Specification;
import com.offcn.dao.TbSpecificationMapper;
import com.offcn.dao.TbSpecificationOptionMapper;
import com.offcn.pojo.TbSpecification;
import com.offcn.pojo.TbSpecificationExample;
import com.offcn.pojo.TbSpecificationExample.Criteria;
import com.offcn.pojo.TbSpecificationOption;
import com.offcn.pojo.TbSpecificationOptionExample;
import com.offcn.service.SpecificationService;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;

	@Autowired
	private TbSpecificationOptionMapper tbSpecificationOptionMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		// 先去添加规格，然后再去添加规格选项
		specificationMapper.insert(specification.getTbSpecification());

		List<TbSpecificationOption> list = specification.getspecificationOptionList();
		for (TbSpecificationOption tbSpecificationOption : list) {
			tbSpecificationOption.setSpecId(specification.getTbSpecification().getId());
			tbSpecificationOptionMapper.insert(tbSpecificationOption);
		}
	}

	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification) {
		specificationMapper.updateByPrimaryKeySelective(specification.getTbSpecification());
		
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		
		com.offcn.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		
		criteria.andSpecIdEqualTo(specification.getTbSpecification().getId());
		
		tbSpecificationOptionMapper.deleteByExample(example);

		List<TbSpecificationOption> list = specification.getspecificationOptionList();
		for (TbSpecificationOption tbSpecificationOption : list) {
			tbSpecificationOption.setSpecId(specification.getTbSpecification().getId());
			tbSpecificationOptionMapper.insertSelective(tbSpecificationOption);
		}
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id) {
		TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		com.offcn.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<TbSpecificationOption> list = tbSpecificationOptionMapper.selectByExample(example);
		Specification specification = new Specification();
		specification.setTbSpecification(tbSpecification);
		specification.setspecificationOptionList(list);
		return specification;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			specificationMapper.deleteByPrimaryKey(id);
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			com.offcn.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			tbSpecificationOptionMapper.deleteByExample(example);
		}
	}

	@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbSpecificationExample example = new TbSpecificationExample();
		
		Criteria criteria = example.createCriteria();
		
		if (specification != null) {
			if (specification.getSpecName() != null && specification.getSpecName().length() > 0) {
				criteria.andSpecNameLike("%" + specification.getSpecName() + "%");
			}
		}

		Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectOptionList() {
		List<Map> list = specificationMapper.selectOptionList();
		return list;
	}

}














