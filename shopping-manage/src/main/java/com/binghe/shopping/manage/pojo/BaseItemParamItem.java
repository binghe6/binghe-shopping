package com.binghe.shopping.manage.pojo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor="of")
@Accessors(chain=true)
public class BaseItemParamItem {
    private Long id;

    private Long itemId;

    private Date createTime;

    private Date updateTime;

    private String paramData;

}