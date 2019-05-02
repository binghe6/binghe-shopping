package com.binghe.shopping.common.bean.resp;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

import com.alibaba.fastjson.annotation.JSONField;

@Data(staticConstructor="of")
@Accessors(chain=true)
public class ItemCatResult {

	@JSONField(name="data")
	private List<ItemCatData> itemCats = new ArrayList<ItemCatData>();

}
