package cn.partytime.repository.manager;

import cn.partytime.model.DanmuClientParams;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by liuwei on 16/6/15.
 */

@EnableMongoRepositories(mongoTemplateRef = "managerMongoTemplate")
public interface DanmuClientParamsRepository extends MongoRepository<DanmuClientParams,String> {

    public DanmuClientParams findById(String id);


}
