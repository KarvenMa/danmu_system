package cn.partytime.model;

import cn.partytime.baseModel.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * Created by liuwei on 16/6/12.
 * 弹幕活动
 */
@Document(collection = "danmu_party")
public class DanmuParty extends BaseModel {

    @Field("_id")
    private String id;

    private String name;

    private Integer type;

    private String DanmuAddressId;

    private Date startTime;

    private Date endTime;

    private String danmuPoolId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDanmuAddressId() {
        return DanmuAddressId;
    }

    public void setDanmuAddressId(String danmuAddressId) {
        DanmuAddressId = danmuAddressId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDanmuPoolId() {
        return danmuPoolId;
    }

    public void setDanmuPoolId(String danmuPoolId) {
        this.danmuPoolId = danmuPoolId;
    }
}

