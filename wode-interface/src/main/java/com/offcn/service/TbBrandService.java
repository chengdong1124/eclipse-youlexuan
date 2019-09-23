package com.offcn.service;

import java.util.List;

import com.offcn.common.PageResult;
import com.offcn.pojo.TbBrand;

public interface TbBrandService {

	List<TbBrand> findAll();

	PageResult findPage(int pageNum, int pageSize);


	void addBrand(TbBrand tbBrand);

	TbBrand findOne(long id);
	
	void updateBrand(TbBrand tbBrand);

	void deleteBrand(Long[] id);

}
