package cn.partytime.repository.manager;

import cn.partytime.model.PreDanmu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

/**
 * Created by liuwei on 16/6/15.
 */

@EnableMongoRepositories(mongoTemplateRef = "managerMongoTemplate")
public interface PreDanmuRepository extends MongoRepository<PreDanmu,String> {

    @Query("findAll().sort().skip()")
    public List<PreDanmu> findByStartNum(int startNum);


}
