package com.binghe.shopping.manage.pojo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
@Data(staticConstructor="of")
@Accessors(chain=true)
public class BaseItemParam {
    private Long id;

    private Long itemCatId;
    
    private String itemCatName;

    private Date createTime;

    private Date updateTime;

    private String paramData;

}