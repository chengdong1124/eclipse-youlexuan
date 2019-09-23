package com.offcn.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.TbBrand;

public interface BrandService {

    public TbBrand findBrandById(long brandId);
    
    PageInfo<TbBrand> findAll();
}
