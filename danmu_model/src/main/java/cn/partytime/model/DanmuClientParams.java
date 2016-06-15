package cn.partytime.model;

import cn.partytime.baseModel.BaseModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by liuwei on 16/6/15.
 */
@Document(collection = "danmu_client_params")
public class DanmuClientParams extends BaseModel {

    @Field("_id")
    private String id;

    private List<String> paramIdList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getParamIdList() {
        return paramIdList;
    }

    public void setParamIdList(List<String> paramIdList) {
        this.paramIdList = paramIdList;
    }
}
