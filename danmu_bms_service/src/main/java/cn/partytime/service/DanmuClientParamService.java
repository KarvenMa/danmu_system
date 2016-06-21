package cn.partytime.service;

import cn.partytime.model.DanmuClientParam;
import cn.partytime.repository.manager.DanmuClientParamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class DanmuClientParamService {

    @Autowired
    private DanmuClientParamRepository danmuClientParamRepository;

    @Resource(name="managerMongoTemplate")
    private MongoOperations mongoOperation;

    public DanmuClientParam save(DanmuClientParam danmuClientParam){
        return danmuClientParamRepository.insert(danmuClientParam);
    }

    public void save(List<DanmuClientParam> danmuClientParamList){
        danmuClientParamRepository.insert(danmuClientParamList);
    }


    public void deleteById(String id){
        danmuClientParamRepository.delete(id);
    }

    public DanmuClientParam updateById(DanmuClientParam danmuClientParam){
        return danmuClientParamRepository.save(danmuClientParam);
    }

    public DanmuClientParam findById(String id){
        return danmuClientParamRepository.findById(id);
    }

    public List<DanmuClientParam> findByIds(List<String> ids){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").in(ids));
        return mongoOperation.find(query,DanmuClientParam.class);
    }




}
