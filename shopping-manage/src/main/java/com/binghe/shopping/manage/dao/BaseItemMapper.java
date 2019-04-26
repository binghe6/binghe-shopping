package com.binghe.shopping.manage.dao;

import com.binghe.shopping.manage.pojo.BaseItem;

public interface BaseItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseItem record);

    int insertSelective(BaseItem record);

    BaseItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseItem record);

    int updateByPrimaryKey(BaseItem record);
}