package com.offcn.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.common.MD5Utils;
import com.offcn.common.PageResult;
import com.offcn.common.Result;
import com.offcn.pojo.TbSeller;
import com.offcn.service.SellerService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSeller> findAll(){			
		return sellerService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return sellerService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param seller
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbSeller seller){
		try {
			sellerService.add(seller);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param seller
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbSeller seller){
		try {
			sellerService.update(seller);
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
	public TbSeller findOne(String sellerId){
		return sellerService.findOne(sellerId);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(String [] sellerIds){
		try {
			sellerService.delete(sellerIds);
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
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbSeller seller, int page, int rows  ){
		return sellerService.findPage(seller, page, rows);		
	}
	
	@RequestMapping("/name")
	public Map getUserName() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Map map = new HashMap();
		map.put("loginName", name);
		return map;
	}
	@RequestMapping("/changePwd")
	public Result changePwd(String oldPwd,String newPwd,String Pwd) {
		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
		TbSeller tbSeller = sellerService.findOne(sellerId);
		String password = tbSeller.getPassword();
		//String oldPassword = MD5Utils.md5(oldPwd);
		if(oldPwd.equals(password)) {
			if(newPwd.equals(Pwd)) {
				tbSeller.setPassword(MD5Utils.md5(newPwd));
				try {
					sellerService.update(tbSeller);
					return new Result(true,"修改成功");
				} catch (Exception e) {
					return new Result(true,"修改失败");
				}
			}else {
				return new Result(false,"两次密码不一致");
			}
		}else {
			return new Result(false,"原密码错误");
		}
		
	}
}



















