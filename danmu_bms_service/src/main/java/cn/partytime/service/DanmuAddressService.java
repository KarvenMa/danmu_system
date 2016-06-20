package cn.partytime.service;

import cn.partytime.model.DanmuAddress;
import cn.partytime.repository.manager.DanmuAddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class DanmuAddressService {

    @Autowired
    private DanmuAddressRepository danmuAddressRepository;

    public DanmuAddress save(DanmuAddress danmuAddress){
       return danmuAddressRepository.insert(danmuAddress);
    }

    public void deleteById(String id){
        danmuAddressRepository.delete(id);
    }

    public DanmuAddress updateById(DanmuAddress danmuAddress){
       return danmuAddressRepository.save(danmuAddress);
    }

    public DanmuAddress findById(String id){
        return danmuAddressRepository.findById(id);
    }

    public Page<DanmuAddress> findAll(int page , int size){
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        PageRequest pageRequest = new PageRequest(page,size,sort);
        return danmuAddressRepository.findAll(pageRequest);
    }

}
