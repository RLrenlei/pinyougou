package com.rl.sellergoods.service;

import com.rl.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	public List<TbBrand> findAll();
	//返回分页列表
	//pageNum:当前页面，pageSize 每页记录数
	public PageResult findPage(int pageNum, int pageSize);
	//增加品牌
	public void add(TbBrand brand);
	//修改品牌
	public void update(TbBrand brand);
	//根据id获取实体
	public TbBrand findOne(long id);
	//批量删除
	public void delete(long[] ids);
	//分页
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize);

	//模板管理中新增品牌下拉框数据
	List<Map> selectOptionList();
}
