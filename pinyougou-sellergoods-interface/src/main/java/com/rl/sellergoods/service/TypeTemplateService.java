package com.rl.sellergoods.service;

import com.rl.pojo.TbTypeTemplate;
import entity.PageResult;

/**
 * @Author Ren
 * @Description //TODO 模板管理
 * @Date 2018/10/8 17:28
 * @Param
 * @return
 **/
public interface TypeTemplateService {
    //查询
    PageResult findPage(TbTypeTemplate typeTemplate, int page, int rows);

    void add(TbTypeTemplate typeTemplate);

    TbTypeTemplate findOne(Long id);

    void update(TbTypeTemplate typeTemplate);

    void delete(long[] ids);
}
