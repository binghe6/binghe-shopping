package com.binghe.shopping.manage.dao;

import com.binghe.shopping.manage.pojo.BaseItemDesc;

public interface BaseItemDescMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseItemDesc record);

    int insertSelective(BaseItemDesc record);

    BaseItemDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseItemDesc record);

    int updateByPrimaryKeyWithBLOBs(BaseItemDesc record);

    int updateByPrimaryKey(BaseItemDesc record);
}