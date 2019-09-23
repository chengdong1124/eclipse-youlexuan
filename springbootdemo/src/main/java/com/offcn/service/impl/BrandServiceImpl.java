package com.offcn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.dao.TbBrandMapper;
import com.offcn.pojo.TbBrand;
import com.offcn.service.BrandService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public TbBrand findBrandById(long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

	@Override
	public PageInfo<TbBrand> findAll() {
		PageHelper.startPage(1,3);
		List<TbBrand> list = brandMapper.selectByExample(null);
		PageInfo<TbBrand> page = new PageInfo(list);
//		page.getList();
//		page.getSize();
//		page.getPageSize();
//		page.getTotal();
		return page;
	}
}
















