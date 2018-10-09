package com.rl.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rl.pojo.TbTypeTemplate;
import com.rl.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TypeTemplateController
 * @Description TODO 模板管理
 * @Author: Ren
 * @Date:Created in 2018/10/8 17:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Reference
    private TypeTemplateService typeTemplateService;

    //查询
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbTypeTemplate typeTemplate, int page, int rows){
        PageResult pageResult = typeTemplateService.findPage(typeTemplate,page,rows);
        return  pageResult;
    }

    //增加
    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate typeTemplate) {
        Result result = null;
        try {
            typeTemplateService.add(typeTemplate);
            result = new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "增加失败");
        }
        return result;
    }

    /**
     * @Author Ren
     * @Description //TODO 修改模板
     * @Date 2018/10/9 9:10
     * @Param [typeTemplate]
     * @return entity.Result
     **/
    @RequestMapping("/update")
    public Result update(@RequestBody TbTypeTemplate typeTemplate) {
        Result result = null;
        try {
            typeTemplateService.update(typeTemplate);
            result = new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false,"修改失败");
        }
        return result;
    }

    /**
     * @Author Ren
     * @Description //TODO 获取实体
     * @Date 2018/10/9 9:10
     * @Param [id]
     * @return com.rl.pojo.TbTypeTemplate
     **/
    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Long id) {
        TbTypeTemplate typeTemplate = typeTemplateService.findOne(id);
        return typeTemplate;
    }

    /**
     * @Author Ren
     * @Description //TODO 删除
     * @Date 2018/10/9 10:55
     * @Param [ids]
     * @return entity.Result
     **/
    @RequestMapping("/delete")
    public Result delete(long[] ids){
        Result result = null;
        try {
            typeTemplateService.delete(ids);
            result = new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "删除失败");
        }
        return result;
    }

}
