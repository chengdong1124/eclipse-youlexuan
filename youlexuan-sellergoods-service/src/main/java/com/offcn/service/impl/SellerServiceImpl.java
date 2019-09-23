package com.offcn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.common.PageResult;
import com.offcn.dao.TbSellerMapper;
import com.offcn.pojo.TbSeller;
import com.offcn.pojo.TbSellerExample;
import com.offcn.pojo.TbSellerExample.Criteria;
import com.offcn.service.SellerService;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private TbSellerMapper sellerMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbSeller> findAll() {
		return sellerMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbSeller> page = (Page<TbSeller>) sellerMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbSeller seller) {
		seller.setStatus("0");
		seller.setCreateTime(new Date());
		sellerMapper.insertSelective(seller);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbSeller seller) {
		sellerMapper.updateByPrimaryKey(seller);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbSeller findOne(String sellerId) {
		TbSeller tbSeller = sellerMapper.selectByPrimaryKey(sellerId);
		return tbSeller;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] sellerIds) {
		for (String sellerId : sellerIds) {
			sellerMapper.deleteByPrimaryKey(sellerId);
		}
	}

	@Override
	public PageResult findPage(TbSeller seller, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbSellerExample example = new TbSellerExample();
		Criteria criteria = example.createCriteria();

		if (seller != null) {
			if(seller.getName() != null && seller.getName().length()>0) {
				criteria.andNameLike("%"+seller.getName()+"%");
			}
			if(seller.getNickName() != null && seller.getNickName().length()>0) {
				criteria.andNickNameLike("%"+seller.getNickName()+"%");
			}
			if(seller.getStatus() != null && seller.getStatus().length()>0) {
				criteria.andStatusEqualTo(seller.getStatus());
			}
		}

		Page<TbSeller> page = (Page<TbSeller>) sellerMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void updateStatus(String sellerId, String status) {
		TbSeller tbSeller = sellerMapper.selectByPrimaryKey(sellerId);
		tbSeller.setStatus(status);
		sellerMapper.updateByPrimaryKeySelective(tbSeller);
		
	}

}
















