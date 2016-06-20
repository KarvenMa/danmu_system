package cn.partytime.repository.manager;

import cn.partytime.model.BlockKeyword;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by liuwei on 16/6/15.
 */

@EnableMongoRepositories(mongoTemplateRef = "managerMongoTemplate")
public interface BlockKeywordRepository extends MongoRepository<BlockKeyword,String> {

    BlockKeyword findByWord(String word);
}
