package com.offcn.controller;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.container.page.PageServlet;
import com.alibaba.fastjson.JSON;
import com.offcn.common.Good;
import com.offcn.common.PageResult;
import com.offcn.common.Result;
import com.offcn.pojo.TbGoods;
import com.offcn.pojo.TbItem;
import com.offcn.service.GoodsService;
import com.offcn.service.ItemCatService;
import com.offcn.service.ItemPageService;
import com.offcn.service.ItemService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private SolrTemplate solrTemplate;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ActiveMQQueue activeMQQueue;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll(){			
		return goodsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return goodsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param goods
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Good good){
		try {
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			good.getGoods().setSellerId(userName);
			goodsService.add(good);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Good good){
		try {
			Long id = good.getGoods().getId();
			Query query = new SimpleQuery("goodsId:"+id+"");
			solrTemplate.delete(query);
			solrTemplate.commit();
			goodsService.update(good);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Good findOne(Long id){
		return goodsService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			
			for (Long id : ids) {
				Query query = new SimpleQuery("goodsId:"+id+"");
				solrTemplate.delete(query);
				solrTemplate.commit();
			}
			
			goodsService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	//不用的商家有不同的商品，所以在查询的时候需要根据不同的商家的id来查
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		goods.setSellerId(userName);
		return goodsService.findPage(goods, page, rows);		
	}
	
	@RequestMapping("/updateStatus")
	public Result updateStatus(long[] ids,String status) {
		try {
			//status是2需要添加到数据库，是3的话就对应删除solr库
			if(status.equals("2")) {
				
				for (final long id : ids) {
					
					//用mq实现
					jmsTemplate.send(activeMQQueue, new MessageCreator() {
						
						@Override
						public Message createMessage(Session session) throws JMSException {
							TextMessage msg = session.createTextMessage(id+"");
							System.out.println("发送成功");
							return msg;
						}
					});
					
					
					List<TbItem> list = itemService.findItemByGoodId(id);
					for (TbItem item : list) {
						Map<String,String> map = JSON.parseObject(item.getSpec(),Map.class);
						item.setSpecMap(map);	
					}
					solrTemplate.saveBeans(list);
					solrTemplate.commit();
				}
				
			}
			//审核不通过(意义不大，前面修改的时候已经删除了)
			if(status.equals("3")) {
				for (Long id : ids) {
					Query query = new SimpleQuery("goodsId:"+id+"");
					solrTemplate.delete(query);
					solrTemplate.commit();
				}
			}
			goodsService.updateStatus(ids,status);
			return new Result(true,"提交审核成功");
		} catch (Exception e) {
			return new Result(false,"提交审核失败");
		}
	}
}















