package cn.partytime.model;

import cn.partytime.baseModel.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by liuwei on 16/6/15.
 * 弹幕池
 */
@Document(collection = "danmu_pool")
public class DanmuPool extends BaseModel {

    @Field("_id")
    private String id;

    private Date createTime;

    /**
     * 弹幕池类型 0:普通弹幕池  1:预制弹幕池
     */
    private Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
