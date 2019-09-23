package com.offcn.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.common.Good;
import com.offcn.common.PageResult;
import com.offcn.dao.TbBrandMapper;
import com.offcn.dao.TbGoodsDescMapper;
import com.offcn.dao.TbGoodsMapper;
import com.offcn.dao.TbItemCatMapper;
import com.offcn.dao.TbItemMapper;
import com.offcn.dao.TbSellerMapper;
import com.offcn.pojo.TbBrand;
import com.offcn.pojo.TbGoods;
import com.offcn.pojo.TbGoodsDesc;
import com.offcn.pojo.TbGoodsExample;
import com.offcn.pojo.TbGoodsExample.Criteria;
import com.offcn.pojo.TbItem;
import com.offcn.pojo.TbItemCat;
import com.offcn.pojo.TbItemExample;
import com.offcn.pojo.TbSeller;
import com.offcn.service.GoodsService;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private TbGoodsMapper goodsMapper;
	@Autowired
	private TbGoodsDescMapper goodsDescMapper;
	@Autowired
	private TbBrandMapper tbBrandMapper;
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Autowired
	private TbSellerMapper tbSellerMapper;

	@Autowired
	private TbItemMapper tbItemMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbGoods> findAll() {
		return goodsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Good good) {

		good.getGoods().setAuditStatus("0");
		goodsMapper.insertSelective(good.getGoods());

		good.getGoodsDesc().setGoodsId(good.getGoods().getId());
		goodsDescMapper.insertSelective(good.getGoodsDesc());
		if(good.getGoods().getIsEnableSpec().equals("1")) {
			List<TbItem> itemList = good.getItemList();
			for (TbItem item : itemList) {
				String title = good.getGoods().getGoodsName();
				Map<String, Object> map1 = JSON.parseObject(item.getSpec());
				Set<String> keySet = map1.keySet();
				for (String key : keySet) {
					title = title + map1.get(key);
				}
				item.setTitle(title);
				item.setGoodsId(good.getGoods().getId());
				item.setSellerId(good.getGoods().getSellerId());
				item.setCategoryid(good.getGoods().getCategory3Id());
				item.setCreateTime(new Date());
				item.setUpdateTime(new Date());
				TbBrand brand = tbBrandMapper.selectByPrimaryKey(good.getGoods().getBrandId());
				item.setBrand(brand.getName());
				TbItemCat itemCat = tbItemCatMapper.selectByPrimaryKey(good.getGoods().getCategory3Id());
				item.setCategory(itemCat.getName());
				TbSeller seller = tbSellerMapper.selectByPrimaryKey(good.getGoods().getSellerId());
				item.setSeller(seller.getNickName());
				List<Map> list = JSON.parseArray(good.getGoodsDesc().getItemImages(), Map.class);
				if (list.size() > 0) {
					item.setImage((String) list.get(0).get("url"));// 默认去第一张图片
				}
				tbItemMapper.insertSelective(item);
			}

		}else {
			TbItem item = new TbItem();
			item.setTitle(good.getGoods().getGoodsName());//因为没有规格，所以title就这样就可以了
			item.setPrice(good.getGoods().getPrice());
			item.setStatus("0");
			item.setIsDefault("1");
			item.setNum(999);
			item.setSpec("{}");
			item.setGoodsId(good.getGoods().getId());
			item.setSeller(good.getGoods().getSellerId());
			item.setGoodsId(good.getGoods().getCategory3Id());
			item.setCreateTime(new Date());
			TbBrand brand = tbBrandMapper.selectByPrimaryKey(good.getGoods().getBrandId());
			item.setBrand(brand.getName());
			TbItemCat itemCat = tbItemCatMapper.selectByPrimaryKey(good.getGoods().getCategory3Id());
			item.setCategory(itemCat.getName());
			TbSeller seller = tbSellerMapper.selectByPrimaryKey(good.getGoods().getSellerId());
			item.setSeller(seller.getNickName());
			List<Map> list = JSON.parseArray(good.getGoodsDesc().getItemImages(), Map.class);
			if (list.size() > 0) {
				item.setImage((String) list.get(0).get("url"));// 默认去第一张图片
			}
			tbItemMapper.insertSelective(item);
		}

		
	}

	/**
	 * 修改
	 */
	@Override
	public void update(Good good) {
		
		good.getGoods().setAuditStatus("0");
		goodsMapper.updateByPrimaryKeySelective(good.getGoods());
		goodsDescMapper.updateByPrimaryKeySelective(good.getGoodsDesc());
		if("1".equals(good.getGoods().getIsEnableSpec())) {
			//如果启用规格就需要修改TbItem表
			
			TbItemExample example = new TbItemExample();
			com.offcn.pojo.TbItemExample.Criteria criteria = example.createCriteria();
			criteria.andGoodsIdEqualTo(good.getGoods().getId());
			
			tbItemMapper.deleteByExample(example);
			
			List<TbItem> itemList = good.getItemList();
			for (TbItem item : itemList) {
				String title = good.getGoods().getGoodsName();
				Map<String, Object> map1 = JSON.parseObject(item.getSpec());
				Set<String> keySet = map1.keySet();
				for (String key : keySet) {
					title = title + map1.get(key);
				}
				item.setTitle(title);
				item.setGoodsId(good.getGoods().getId());
				item.setSellerId(good.getGoods().getSellerId());
				item.setCategoryid(good.getGoods().getCategory3Id());
				item.setCreateTime(new Date());
				item.setUpdateTime(new Date());
				TbBrand brand = tbBrandMapper.selectByPrimaryKey(good.getGoods().getBrandId());
				item.setBrand(brand.getName());
				TbItemCat itemCat = tbItemCatMapper.selectByPrimaryKey(good.getGoods().getCategory3Id());
				item.setCategory(itemCat.getName());
				TbSeller seller = tbSellerMapper.selectByPrimaryKey(good.getGoods().getSellerId());
				item.setSeller(seller.getNickName());
				List<Map> list = JSON.parseArray(good.getGoodsDesc().getItemImages(), Map.class);
				if (list.size() > 0) {
					item.setImage((String) list.get(0).get("url"));// 默认去第一张图片
				}
				tbItemMapper.insertSelective(item);
			}
		}else {
			//不起用规格
			List<TbItem> itemList = good.getItemList();
			for (TbItem item : itemList) {
				String title = good.getGoods().getGoodsName();
				Map<String, Object> map1 = JSON.parseObject(item.getSpec());
				Set<String> keySet = map1.keySet();
				for (String key : keySet) {
					title = title + map1.get(key);
				}
				item.setTitle(title);
				item.setGoodsId(good.getGoods().getId());
				item.setSellerId(good.getGoods().getSellerId());
				item.setCategoryid(good.getGoods().getCategory3Id());
				item.setCreateTime(new Date());
				item.setUpdateTime(new Date());
				TbBrand brand = tbBrandMapper.selectByPrimaryKey(good.getGoods().getBrandId());
				item.setBrand(brand.getName());
				TbItemCat itemCat = tbItemCatMapper.selectByPrimaryKey(good.getGoods().getCategory3Id());
				item.setCategory(itemCat.getName());
				TbSeller seller = tbSellerMapper.selectByPrimaryKey(good.getGoods().getSellerId());
				item.setSeller(seller.getNickName());
				List<Map> list = JSON.parseArray(good.getGoodsDesc().getItemImages(), Map.class);
				if (list.size() > 0) {
					item.setImage((String) list.get(0).get("url"));// 默认去第一张图片
				}
				tbItemMapper.insertSelective(item);
			}
		}
		
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Good findOne(Long id) {
		TbGoods goods = goodsMapper.selectByPrimaryKey(id);
		TbGoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(id);
		TbItemExample example = new TbItemExample();
		com.offcn.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(id);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		Good good = new Good();
		good.setGoods(goods);
		good.setGoodsDesc(goodsDesc);
		good.setItemList(list);
		return good;
	}
		

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			goodsMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		TbGoodsExample example = new TbGoodsExample();
		Criteria criteria = example.createCriteria();

		//在这这个goods其实100%不为null，哪怕前台没有让他携带任何参数
		if (goods != null) {
			if(goods.getSellerId() != null && goods.getSellerId().length()>0) {
				criteria.andSellerIdEqualTo(goods.getSellerId());
			}
			if(goods.getAuditStatus() != null && goods.getAuditStatus().length()>0) {
				criteria.andAuditStatusEqualTo(goods.getAuditStatus());
			}
			if(goods.getGoodsName() != null && goods.getGoodsName().length()>0) {
				criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
			}
		}
		Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void updateStatus(long[] ids,String status) {
		
		for (long id:ids) {
			TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
			tbGoods.setAuditStatus(status);
			goodsMapper.updateByPrimaryKeySelective(tbGoods);
			TbItemExample example = new TbItemExample();
			com.offcn.pojo.TbItemExample.Criteria criteria = example.createCriteria();
			criteria.andGoodsIdEqualTo(id);
			List<TbItem> list = tbItemMapper.selectByExample(example);
			for (TbItem item : list) {
				item.setStatus(status);
				tbItemMapper.updateByPrimaryKeySelective(item);
			}
		}
		
	}

}











