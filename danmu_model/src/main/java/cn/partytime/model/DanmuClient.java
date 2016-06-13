package cn.partytime.model;

import cn.partytime.baseModel.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by liuwei on 16/6/12.
 * 弹幕客户端
 */
@Document(collection = "danmu_client")
public class DanmuClient extends BaseModel{

    @Field("_id")
    private String id;

    private String name;

    private String creatorId;

    private String registCode;

    /**
     * 创建注册码的时间
     */
    private Date registCodeCreateTime;

    /**
     * 由客户端生成的唯一标识
     */
    private String danmuClientCode;


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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public Date getRegistCodeCreateTime() {
        return registCodeCreateTime;
    }

    public void setRegistCodeCreateTime(Date registCodeCreateTime) {
        this.registCodeCreateTime = registCodeCreateTime;
    }

    public String getDanmuClientCode() {
        return danmuClientCode;
    }

    public void setDanmuClientCode(String danmuClientCode) {
        this.danmuClientCode = danmuClientCode;
    }
}
