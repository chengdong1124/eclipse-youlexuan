package com.offcn.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcn.common.Good;
import com.offcn.common.PageResult;
import com.offcn.common.Result;
import com.offcn.pojo.TbGoods;
import com.offcn.service.GoodsService;
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
							//这里参数和service.js传过来的顺序不一样
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		goods.setSellerId(userName);
		return goodsService.findPage(goods, page, rows);		
	}
	
	@RequestMapping("/updateStatus")
	public Result updateStatus(long[] ids,String status) {
		try {
			goodsService.updateStatus(ids,status);
			return new Result(true,"提交审核成功");
		} catch (Exception e) {
			return new Result(false,"提交审核失败");
		}
	}
	
}















