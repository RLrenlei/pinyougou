package com.rl.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rl.mapper.TbSpecificationMapper;
import com.rl.mapper.TbSpecificationOptionMapper;
import com.rl.pojo.TbSpecification;
import com.rl.pojo.TbSpecificationExample;
import com.rl.pojo.TbSpecificationOption;
import com.rl.pojo.TbSpecificationOptionExample;
import com.rl.pojogroup.Specification;
import com.rl.sellergoods.service.SpecificationService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SpecificationServiceImpl
 * @Description TODO 商品规格管理
 * @Author: Ren
 * @Date:Created in 2018/10/8 10:57
 * @Version 1.0
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper specificationMapper;
    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;
    //查询全部列表
    @Override
    public List<TbSpecification> findAll() {
        List<TbSpecification> list = specificationMapper.selectByExample(null);
        return list;
    }

    //分页
    @Override
    public PageResult findPage(TbSpecification specification, int page, int rows) {
        PageHelper.startPage(page,rows);
        TbSpecificationExample example = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();
        if(specification!=null){
            if(specification.getSpecName()!=null && specification.getSpecName().length()>0) {
                criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
            }
        }
        Page<TbSpecification> result = (Page<TbSpecification>) specificationMapper.selectByExample(example);
        PageResult pageResult = new PageResult(result.getTotal(),result.getResult());
        return pageResult;
    }

    //增加
    @Override
    public void add(Specification specification) {
        TbSpecification tbSpecification = specification.getSpecification();
        specificationMapper.insert(tbSpecification);//插入规格
        List<TbSpecificationOption> optionList = specification.getSpecificationOptionList();
        //循环插入规格选项
        for(TbSpecificationOption option:optionList) {
            option.setSpecId(specification.getSpecification().getId());
            specificationOptionMapper.insert(option);
        }
    }

    //根据id获取实体
    @Override
    public Specification findOne(Long id) {
        //查询规格
        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
        //查询规格选项列表
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);//根据id查询
        List<TbSpecificationOption> optionList = specificationOptionMapper.selectByExample(example);
        //构建组合实体类返回结果
        Specification specification = new Specification();
        specification.setSpecification(tbSpecification);
        specification.setSpecificationOptionList(optionList);
        return specification;
    }

    //修改保存结果
    @Override
    public void update(Specification specification) {
        //保存修改的规格
        specificationMapper.updateByPrimaryKey(specification.getSpecification());
        //删除原有的规格选项
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(specification.getSpecification().getId());
        specificationOptionMapper.deleteByExample(example);
        //循环插入规格选项
        List<TbSpecificationOption> list = specification.getSpecificationOptionList();
        for(TbSpecificationOption option:list) {
            option.setSpecId(specification.getSpecification().getId());
            specificationOptionMapper.insert(option);
        }
    }

    //批量删除
    @Override
    public void delete(Long[] ids) {
        for(long id:ids) {
            specificationMapper.deleteByPrimaryKey(id);
            //删除原有的规格选项
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            specificationOptionMapper.deleteByExample(example);
        }
    }

    //显示下拉数据
    @Override
    public List<Map> selectSpecificationList() {
        List<Map> list = specificationMapper.selectSpecificationList();
        return list;
    }
}
