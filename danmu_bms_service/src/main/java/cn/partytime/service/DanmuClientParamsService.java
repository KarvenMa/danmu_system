package cn.partytime.service;

import cn.partytime.model.DanmuClientParams;
import cn.partytime.repository.manager.DanmuClientParamsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class DanmuClientParamsService {

    @Autowired
    private DanmuClientParamsRepository danmuClientParamsRepository;

    public DanmuClientParams save(DanmuClientParams danmuClientParams){
        return danmuClientParamsRepository.insert(danmuClientParams);
    }

    public void deleteById(String id){
        danmuClientParamsRepository.delete(id);
    }

    public DanmuClientParams updateById(DanmuClientParams danmuClientParams){
        return danmuClientParamsRepository.save(danmuClientParams);
    }

    public DanmuClientParams findById(String id){
        return danmuClientParamsRepository.findById(id);
    }


}
