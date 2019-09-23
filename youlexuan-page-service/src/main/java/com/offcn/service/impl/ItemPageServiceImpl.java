package com.offcn.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.offcn.dao.TbGoodsDescMapper;
import com.offcn.dao.TbGoodsMapper;
import com.offcn.dao.TbItemCatMapper;
import com.offcn.dao.TbItemMapper;
import com.offcn.pojo.TbGoods;
import com.offcn.pojo.TbGoodsDesc;
import com.offcn.pojo.TbItem;
import com.offcn.pojo.TbItemExample;
import com.offcn.pojo.TbItemExample.Criteria;
import com.offcn.service.ItemPageService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class ItemPageServiceImpl implements ItemPageService {

	@Autowired
	private FreeMarkerConfig freeMarkerConfig;

	@Autowired
	private TbGoodsMapper tbGoodsMapper;

	@Autowired
	private TbGoodsDescMapper tbGoodsDescMapper;
	
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public boolean getItemHtml(long goodsId) {

		try {
			// 获取模板
			Configuration configuration = freeMarkerConfig.getConfiguration();
			Template template = configuration.getTemplate("item.ftl");

			// 获取数据源
			Map map = new HashMap();
			TbGoods goods = tbGoodsMapper.selectByPrimaryKey(goodsId);
			TbGoodsDesc goodsDesc = tbGoodsDescMapper.selectByPrimaryKey(goodsId);
			String category1 = tbItemCatMapper.selectByPrimaryKey(goods.getCategory1Id()).getName();
			String category2 = tbItemCatMapper.selectByPrimaryKey(goods.getCategory2Id()).getName();
			String category3 = tbItemCatMapper.selectByPrimaryKey(goods.getCategory3Id()).getName();
			
			TbItemExample example = new TbItemExample();
			Criteria criteria = example.createCriteria();
			criteria.andGoodsIdEqualTo(goodsId);
			criteria.andStatusEqualTo("2");
			criteria.andIsDefaultEqualTo("0");
			List<TbItem> itemList = tbItemMapper.selectByExample(example);
			
			map.put("itemList", itemList);
			map.put("category1", category1);
			map.put("category2", category2);
			map.put("category3", category3);
			map.put("goods", goods);
			map.put("goodsDesc", goodsDesc);

			// 获取writer对象
			// FileWriter fileWriter = new FileWriter(new
			// File("C:\\Users\\Administrator\\Desktop\\wenjian\\"+goodsId+".html"));

			Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("D:\\workplace_eclipse\\youlexuan-page-web\\src\\main\\webapp\\" + goodsId + ".html"), "UTF-8"));
			template.process(map, writer);

			writer.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
