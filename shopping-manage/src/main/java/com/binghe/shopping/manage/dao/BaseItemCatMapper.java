package com.binghe.shopping.manage.dao;

import java.util.List;
import java.util.Map;

import com.binghe.shopping.manage.pojo.BaseItemCat;

public interface BaseItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseItemCat record);

    int insertSelective(BaseItemCat record);

    BaseItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseItemCat record);

    int updateByPrimaryKey(BaseItemCat record);

	List<BaseItemCat> listByParam(Map<String, Object> param);
}