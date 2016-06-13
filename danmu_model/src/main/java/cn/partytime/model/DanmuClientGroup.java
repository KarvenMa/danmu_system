package cn.partytime.model;

import cn.partytime.baseModel.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * Created by liuwei on 16/6/12.
 * 弹幕客户端组
 */
@Document(collection = "danmu_client_group")
public class DanmuClientGroup extends BaseModel{

    @Field("_id")
    private String id;

    private List<String> danmuClientIdList;

    private String creatorId;

    private Date createTime;

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDanmuClientIdList() {
        return danmuClientIdList;
    }

    public void setDanmuClientIdList(List<String> danmuClientIdList) {
        this.danmuClientIdList = danmuClientIdList;
    }
}
