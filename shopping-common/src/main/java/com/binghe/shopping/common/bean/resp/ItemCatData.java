package com.binghe.shopping.common.bean.resp;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

import com.alibaba.fastjson.annotation.JSONField;

@Data(staticConstructor="of")
@Accessors(chain=true)
public class ItemCatData  {
	
	@JSONField(name="u")// 序列化成json数据时为 u
	private String url;
	
	@JSONField(name="n")
	private String name;
	
	@JSONField(name="i")
	private List<?> items;

}
