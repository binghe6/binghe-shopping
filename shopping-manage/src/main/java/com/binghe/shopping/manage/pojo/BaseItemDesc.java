package com.binghe.shopping.manage.pojo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor="of")
@Accessors(chain=true)
public class BaseItemDesc {
    private Long id;

    private Long itemId;

    private Date createTime;

    private Date updateTime;

    private String itemDesc;
    
    private Long itemIdWhere;// 用于作为条件

}