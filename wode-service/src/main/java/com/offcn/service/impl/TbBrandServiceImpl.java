package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.common.PageResult;
import com.offcn.dao.TbBrandMapper;
import com.offcn.pojo.TbBrand;

import com.offcn.service.TbBrandService;

@Service
public class TbBrandServiceImpl implements TbBrandService {

	@Autowired
	private TbBrandMapper tbBrandMapper;
	
	@Override
	public List<TbBrand> findAll() {
		List<TbBrand> list = tbBrandMapper.selectByExample(null);
		return list;
	}
	
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);//加上pageHelper后查询的数据就是分页的数据
		
		/*Page<TbBrand> page = (Page<TbBrand>)tbBrandMapper.selectByExample(null);
		page.getTotal();
		page.getResult();*/
		
		List<TbBrand> list = tbBrandMapper.selectByExample(null);
		
		PageInfo<TbBrand> page = new PageInfo<>(list);
		
		return new PageResult(page.getTotal(), page.getList());
	}

	@Override
	public void addBrand(TbBrand tbBrand) {
		tbBrandMapper.insertSelective(tbBrand);
		
	}

	@Override
	public TbBrand findOne(long id) {
		return tbBrandMapper.selectByPrimaryKey(id);
		
	}
	
	@Override
	public void updateBrand(TbBrand tbBrand) {
		tbBrandMapper.updateByPrimaryKeySelective(tbBrand);
		
	}

	@Override
	public void deleteBrand(Long[] ids) {
		for (long id : ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
		
		
	}
	
}
