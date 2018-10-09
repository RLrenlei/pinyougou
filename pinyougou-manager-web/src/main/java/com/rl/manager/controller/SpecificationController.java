package com.rl.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.rl.pojo.TbSpecification;
import com.rl.pojogroup.Specification;
import com.rl.sellergoods.service.SpecificationService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SpecificationController
 * @Description TODO 规格管理
 * @Author: Ren
 * @Date:Created in 2018/10/8 11:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    //返回全部列表
    @RequestMapping("/findAll")
    public List<TbSpecification> findAll() {
        List<TbSpecification> list = specificationService.findAll();
        return list;
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbSpecification specification, int page, int rows){
        PageResult pageResult = specificationService.findPage(specification, page, rows);
        return pageResult;
    }
    //增加
    @RequestMapping("/add")
    public Result add(@RequestBody Specification specification) {
        Result result = null;
        try {
            specificationService.add(specification);
            result = new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "增加失败");
        }
        return result;
    }
    //修改
    @RequestMapping("/findOne")
    public Specification findOne(Long id) {
        Specification specification = specificationService.findOne(id);
        return specification;
    }
    //保存修改
    @RequestMapping("/update")
    public Result update(@RequestBody Specification specification) {
        Result result = null;
        try {
            specificationService.update(specification);
            result = new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false,"修改失败");
        }
        return result;
    }
    //删除
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        Result result = null;
        try {
            specificationService.delete(ids);
            result = new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "删除失败");
        }
        return result;
    }
    //显示下拉数据
    @RequestMapping("/selectSpecificationList")
    public List<Map> selectOptionList(){
        List<Map> list = specificationService.selectSpecificationList();
        return list;
    }
}
