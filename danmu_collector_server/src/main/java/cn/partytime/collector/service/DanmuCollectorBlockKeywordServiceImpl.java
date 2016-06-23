package cn.partytime.collector.service;

import cn.partytime.logic.blockKey.BlockKeyCacheModel;
import cn.partytime.model.BlockKeyword;
import cn.partytime.service.BlockKeywordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 弹幕采集器获取敏感词
 * Created by user on 16/6/22.
 */

@Service("danmuCollectorService")
public class DanmuCollectorBlockKeywordServiceImpl implements DanmuCollectorBlockKeywordService {

    @Autowired
    private BlockKeywordService blockKeywordService;

    @Override
    public List<BlockKeyCacheModel> findAll() {
        List<BlockKeyCacheModel> blockKeyCacheModelList = new ArrayList<BlockKeyCacheModel>();
        List<BlockKeyword> blockKeywordList =  blockKeywordService.findAll();
        if(blockKeywordList!=null && !blockKeywordList.isEmpty()){
            for(BlockKeyword blockKeyword:blockKeywordList){
                BlockKeyCacheModel blockKeyCacheModel = new BlockKeyCacheModel();
                BeanUtils.copyProperties(blockKeyword,blockKeyCacheModel);
                blockKeyCacheModel.setStatus(0);
                blockKeyCacheModelList.add(blockKeyCacheModel);
            }
        }
        return blockKeyCacheModelList;

    }
}
