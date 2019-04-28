package com.binghe.shopping.common.bean.resp;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Slf4j
public class EasyUIResp {

    private Integer total;

    private List<?> rows;

    public EasyUIResp() {
    }

    public EasyUIResp(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public EasyUIResp(Long total, List<?> rows) {
        this.total = total.intValue();
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    /**
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static EasyUIResp formatToList(String jsonData, Class<?> clazz) {
        try {
        	JSONObject jsonObject = JSON.parseObject(jsonData);
        	String data = jsonObject.getString("rows");
        	List<?> list = null;
        	if (StringUtils.isNotBlank(data) && data.startsWith("[") && data.endsWith("]")) {
				list = JSONObject.parseArray(data, clazz);
			}
        	return new EasyUIResp(jsonObject.getIntValue("total"), list);
        } catch (Exception e) {
        	log.error("easyui format to list error, data:{}", jsonData, e);
            return null;
        }
    }
}
