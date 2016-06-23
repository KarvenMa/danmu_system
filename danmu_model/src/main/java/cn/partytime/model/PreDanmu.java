package cn.partytime.model;

import cn.partytime.baseModel.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by liuwei on 16/6/15.
 * 预制弹幕
 */

@Document(collection = "pre_danmu")
public class PreDanmu extends BaseModel {

    @Field("_id")
    private String id;

    private String color;

    private String msg;

    private String danmuPoolId;

    private Date startTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDanmuPoolId() {
        return danmuPoolId;
    }

    public void setDanmuPoolId(String danmuPoolId) {
        this.danmuPoolId = danmuPoolId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
