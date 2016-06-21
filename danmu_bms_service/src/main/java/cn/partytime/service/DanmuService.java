package cn.partytime.service;

import cn.partytime.model.Danmu;
import cn.partytime.repository.danmu.DanmuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class DanmuService {

    @Autowired
    private DanmuRepository danmuRepository;

    public Danmu save(Danmu danmu){
        return danmuRepository.save(danmu);
    }

    public void deleteById(String id){
        danmuRepository.delete(id);
    }

    public Danmu findById(String id){
        return danmuRepository.findById(id);
    }

    public List<Danmu> findByDanmuPoolId(String danmuPoolId){
        return danmuRepository.findByDanmuPoolId(danmuPoolId);
    }







}
