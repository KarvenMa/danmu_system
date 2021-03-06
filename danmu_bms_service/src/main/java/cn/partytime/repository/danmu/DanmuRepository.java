package cn.partytime.repository.danmu;

import cn.partytime.model.Danmu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

/**
 * Created by liuwei on 16/6/15.
 */
@EnableMongoRepositories(mongoTemplateRef = "danmuMongoTemplate")
public interface DanmuRepository extends MongoRepository<Danmu, String> {

    public Danmu findById(String id);

    public List<Danmu> findByDanmuPoolId(String danmuPoolId);


}
