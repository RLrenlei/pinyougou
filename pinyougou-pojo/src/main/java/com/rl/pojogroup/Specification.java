package com.rl.pojogroup;

import com.rl.pojo.TbSpecification;
import com.rl.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Specification
 * @Description TODO 规格组合实体类
 * @Author: Ren
 * @Date:Created in 2018/10/8 14:15
 * @Version 1.0
 */
public class Specification implements Serializable {
    private TbSpecification specification;

    private List<TbSpecificationOption> specificationOptionList;

    public TbSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(TbSpecification specification) {
        this.specification = specification;
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
