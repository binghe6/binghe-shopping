package com.binghe.shopping.manage.pojo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor="of")
@Accessors(chain=true)
public class BaseItem {
    private Long id;

    private String title;

    private String sellPoint;

    private BigDecimal price;

    private Integer num;

    private String barcode;

    private String image;

    private Long cid;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    /* ---------------枚举---------------- */
    public static final int STATUS_ON = 1;// 正常
    public static final int STATUS_OFF = 2;// 下架
    public static final int STATUS_DEL = 3;// 删除
    /* ---------------枚举---------------- */
}