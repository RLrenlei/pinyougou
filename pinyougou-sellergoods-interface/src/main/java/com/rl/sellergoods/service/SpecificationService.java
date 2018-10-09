package com.rl.sellergoods.service;

import com.rl.pojo.TbSpecification;
import com.rl.pojogroup.Specification;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Author Ren
 * @Description //TODO 商品规格管理
 * @Date 2018/10/8 10:55
 * @Param
 * @return
 **/
public interface SpecificationService {
    //返回全部列表
    List<TbSpecification> findAll();
    //分页
    PageResult findPage(TbSpecification specification, int page, int rows);
    //增加
    void add(Specification specification);
    //根据id获取实体
    public Specification findOne(Long id);
    //保存修改结果
    void update(Specification specification);
    //批量删除
    void delete(Long[] ids);

    //展示下拉数据
    List<Map> selectSpecificationList();
}
