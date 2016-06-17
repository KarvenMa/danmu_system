package cn.partytime.service;

import cn.partytime.model.PreDanmu;
import cn.partytime.repository.manager.PreDanmuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class PreDanmuService {

    @Autowired
    private PreDanmuRepository preDanmuRepository;

    /**
     * 保存一个预制弹幕
     * @param preDanmu
     * @return
     */
    public PreDanmu save(PreDanmu preDanmu){
        return preDanmuRepository.insert(preDanmu);
    }

    /**
     * 保存一组预制弹幕
     * @param preDanmuList
     * @return
     */
    public List<PreDanmu> save(List<PreDanmu> preDanmuList){
        return preDanmuRepository.insert(preDanmuList);
    }

    /**
     * 删除一个预制弹幕
     * @param id
     */
    public void deleteById(String id){
        preDanmuRepository.delete(id);
    }

    /**
     * 查询所有预制弹幕 根据弹幕播放时间排序
     * @return
     */
    public List<PreDanmu> findAll(){
        Sort sort = new Sort(Sort.Direction.DESC,"startTime");
        return preDanmuRepository.findAll(sort);
    }

    /**
     * 分页查询预制弹幕
     * @param page
     * @param size
     * @return
     */
    public Page<PreDanmu> findByPage(int page,int size){
        Sort sort = new Sort(Sort.Direction.DESC,"startTime");
        PageRequest pageRequest = new PageRequest(page,size,sort);
        return preDanmuRepository.findAll(pageRequest);
    }




}
