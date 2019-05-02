package com.binghe.shopping.manage.dao;

import java.util.Map;

import com.binghe.shopping.manage.pojo.BaseItemParamItem;

public interface BaseItemParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseItemParamItem record);

    int insertSelective(BaseItemParamItem record);

    BaseItemParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(BaseItemParamItem record);

    int updateByPrimaryKey(BaseItemParamItem record);

	BaseItemParamItem getByParam(Map<String, Object> param);
}