package com.binghe.shopping.manage.dao;

import java.util.List;
import java.util.Map;

import com.binghe.shopping.manage.pojo.BaseItemParam;

public interface BaseItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseItemParam record);

    int insertSelective(BaseItemParam record);

    BaseItemParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseItemParam record);

    int updateByPrimaryKeyWithBLOBs(BaseItemParam record);

    int updateByPrimaryKey(BaseItemParam record);

	List<BaseItemParam> listByParam(Map<String, Object> param);

	BaseItemParam getByParam(Map<String, Object> param);
}