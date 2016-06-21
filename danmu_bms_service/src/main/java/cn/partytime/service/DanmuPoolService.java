package cn.partytime.service;

import cn.partytime.model.DanmuPool;
import cn.partytime.repository.danmu.DanmuPoolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class DanmuPoolService {

    @Autowired
    private DanmuPoolRepository danmuPoolRepository;

    public DanmuPool save(DanmuPool danmuPool){
        return danmuPoolRepository.insert(danmuPool);
    }

    public void deleteById(String id){
        danmuPoolRepository.delete(id);
    }

    public DanmuPool updateById(DanmuPool danmuPool){
        return danmuPoolRepository.save(danmuPool);
    }

    public DanmuPool findById(String id){
        return danmuPoolRepository.findById(id);
    }

}
