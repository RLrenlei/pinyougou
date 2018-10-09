package com.rl.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rl.pojo.TbBrand;
import com.rl.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author Ren
 * @Description //TODO 品牌管理
 * @Date 2018/9/28 13:34
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;

	//返回全部列表
//	@RequestMapping("/findAll")
//	public List<TbBrand> findAll(){
//		return brandService.findAll();
//	}

//	//分页
//	@RequestMapping("/findPage")
//	public PageResult findPage(int page, int rows) {
//		return brandService.findPage(page, rows);
//	}

	//增加品牌
	@RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand) {
	    try {
	        brandService.add(brand);
	        return new Result(true, "增加成功");
        } catch (Exception e) {
	        e.printStackTrace();
	        return new Result(false, "增加失败");
        }
    }
    //修改品牌
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand) {
		try {
			brandService.update(brand);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
	}
	/**
	 * @Author Ren
	 * @Description //TODO 获取实体
	 * @Date 2018/9/28 15:05
	 * @Param
	 * @return
	 **/
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandService.findOne(id);
	}

	/**
	 * @Author Ren
	 * @Description //TODO 删除
	 * @Date 2018/9/28 17:01
	 * @Param [ids]
	 * @return entity.Result
	 **/
	@RequestMapping("/delete")
	public Result delete(long[] ids){
		try {
			brandService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand, int page, int rows) {
		return brandService.findPage(brand, page, rows);
	}

	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		List<Map> list = brandService.selectOptionList();
		return list;
	}
}
