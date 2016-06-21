package cn.partytime.baseModel;

import java.util.Date;

/**
 * Created by liuwei on 16/6/13.
 */
public class BaseModel {

    private Integer isDelete;

    private Date createTime = new Date();

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
