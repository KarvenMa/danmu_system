package cn.partytime.repository.danmu;

import cn.partytime.model.DanmuPool;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by liuwei on 16/6/15.
 */
@EnableMongoRepositories(mongoTemplateRef = "danmuMongoTemplate")
public interface DanmuPoolRepository extends MongoRepository<DanmuPool, String> {

    public DanmuPool findById(String id);

}
