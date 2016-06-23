package cn.partytime.model;

import cn.partytime.baseModel.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by liuwei on 16/6/12.
 * 弹幕活动的地址
 */
@Document(collection = "danmu_address")
public class DanmuAddress extends BaseModel{

    @Field("_id")
    private String id;

    private String address;

    private String creatoeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatoeId() {
        return creatoeId;
    }

    public void setCreatoeId(String creatoeId) {
        this.creatoeId = creatoeId;
    }

}
