package com.binghe.shopping.manage.pojo;

import java.util.Date;

public class BaseItemCat {
    private Long id;

    private Long parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Integer parentFlag;

    private Date createTime;

    private Date updateTime;

    private String remark;

    /* -----------------枚举---------------- */
    public static final int STATE_ON = 1;// 可用
    public static final int STATE_OFF = 0;// 不可用
    /* -----------------枚举---------------- */
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getParentFlag() {
        return parentFlag;
    }

    public void setParentFlag(Integer parentFlag) {
        this.parentFlag = parentFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * easyui树需要的节点名称
     * @return
     */
    public String getText() {
    	return this.name;
    }
    
    /**
     * easyui树需要的节点是否有子节点的状态
     * @return
     */
    public String getState() {
    	return this.parentFlag == 0 ? "open" : "closed";
    }
}