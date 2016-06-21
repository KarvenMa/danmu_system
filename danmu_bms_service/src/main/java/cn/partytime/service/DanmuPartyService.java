package cn.partytime.service;

import cn.partytime.model.DanmuParty;
import cn.partytime.repository.manager.DanmuPartyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class DanmuPartyService {

    @Autowired
    private DanmuPartyRepository danmuPartyRepository;

    public DanmuParty save(DanmuParty danmuParty){
        return danmuPartyRepository.insert(danmuParty);
    }

    public void deleteById(String id){
        danmuPartyRepository.delete(id);
    }

    public DanmuParty updateById(DanmuParty danmuParty){
        return danmuPartyRepository.save(danmuParty);
    }

    public DanmuParty findById(String id){
        return danmuPartyRepository.findById(id);
    }



}
