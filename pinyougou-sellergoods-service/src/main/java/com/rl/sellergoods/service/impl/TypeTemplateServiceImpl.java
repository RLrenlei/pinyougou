package com.rl.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rl.mapper.TbTypeTemplateMapper;
import com.rl.pojo.TbTypeTemplate;
import com.rl.pojo.TbTypeTemplateExample;
import com.rl.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName TypeTemplateServiceImpl
 * @Description TODO 模板管理
 * @Author: Ren
 * @Date:Created in 2018/10/8 17:29
 * @Version 1.0
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;

    /**
     * @Author Ren
     * @Description //TODO 查询
     * @Date 2018/10/9 9:11
     * @Param [typeTemplate, page, rows]
     * @return entity.PageResult
     **/
    @Override
    public PageResult findPage(TbTypeTemplate typeTemplate, int page, int rows) {
        PageHelper.startPage(page,rows);
        TbTypeTemplateExample example = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();
        if(typeTemplate.getName()!=null && typeTemplate.getName().length()>0) {
            criteria.andNameLike("%"+typeTemplate.getName()+"%");
        }
        Page<TbTypeTemplate> result = (Page<TbTypeTemplate>) typeTemplateMapper.selectByExample(example);
        PageResult pageResult = new PageResult(result.getTotal(), result.getResult());
        return pageResult;
    }

    /**
     * @Author Ren
     * @Description //TODO 增加
     * @Date 2018/10/9 9:11
     * @Param [typeTemplate]
     * @return void
     **/
    @Override
    public void add(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.insert(typeTemplate);
    }

    /**
     * @Author Ren
     * @Description //TODO 得到实体并显示到修改界面
     * @Date 2018/10/9 9:12
     * @Param [id]
     * @return com.rl.pojo.TbTypeTemplate
     **/
    @Override
    public TbTypeTemplate findOne(Long id) {
        TbTypeTemplate tbTypeTemplate = typeTemplateMapper.selectByPrimaryKey(id);
        return tbTypeTemplate;
    }

    /**
     * @Author Ren
     * @Description //TODO 修改
     * @Date 2018/10/9 9:12
     * @Param [typeTemplate]
     * @return void
     **/
    @Override
    public void update(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.updateByPrimaryKey(typeTemplate);
    }

    @Override
    public void delete(long[] ids) {
        for(long id:ids) {
            typeTemplateMapper.deleteByPrimaryKey(id);
        }
    }
}
