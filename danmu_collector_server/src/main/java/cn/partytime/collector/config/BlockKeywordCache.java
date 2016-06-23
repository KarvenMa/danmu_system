package cn.partytime.collector.config;

import cn.partytime.collector.service.DanmuCollectorBlockKeywordService;
import cn.partytime.logic.blockKey.BlockKeyCacheModel;
import cn.partytime.service.DanmuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 缓存敏感词
 */
@Component
public class BlockKeywordCache {

    @Autowired
    private DanmuCollectorBlockKeywordService danmuCollectorBlockKeywordService;

    /*缓存编号 0:cacheA;1:cacheB*/
    private static int cacheNo = 0;
    private static final Map<String, String> cacheA = new HashMap<String, String>();
    private static final Map<String, String> cacheB = new HashMap<String, String>();

    /**
     * 初始化敏感词
     */
    @PostConstruct
    public void init() {
        //从mongo读取所有敏感词
        List<BlockKeyCacheModel> blockKeyCacheModelList = danmuCollectorBlockKeywordService.findAll();
        for (BlockKeyCacheModel blockKeyCacheModel : blockKeyCacheModelList) {
            updateCache(cacheB, blockKeyCacheModel);
            updateCache(cacheA, blockKeyCacheModel);
        }
    }

    /**
     * 获取当前可以取数据的队列
     *
     * @return
     */
    public int getCacheNo() {
        return cacheNo;
    }

    /**
     * 匹配敏感词
     *
     * @param word 敏感词
     * @return
     */
    public boolean matchBlockKey(String word) {
        if (cacheNo == 0) {
            return matchBlockKey(cacheA, word);
        } else {
            return matchBlockKey(cacheB, word);
        }
    }

    boolean matchBlockKey(Map<String, String> map, String word) {

        if (map.size() == 0) {
            return false;
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (word.indexOf(entry.getValue()) != -1) {
                return true;
            }
        }
        return false;
    }


    /**
     * 批量更新
     *
     * @param blockKeyCacheModelList
     */
    public void updateCacheList(List<BlockKeyCacheModel> blockKeyCacheModelList) {
        if (cacheNo == 0) {
            //A队列正在使用。更新B队列
            for (BlockKeyCacheModel blockKeyCacheModel : blockKeyCacheModelList) {
                updateCache(cacheB, blockKeyCacheModel);
            }
            cacheNo = 1;
            cacheA.clear();
            cacheA.putAll(cacheB);
        } else {
            //A队列正在使用。更新B队列
            for (BlockKeyCacheModel blockKeyCacheModel : blockKeyCacheModelList) {
                updateCache(cacheA, blockKeyCacheModel);
            }
            cacheNo = 0;
            cacheB.clear();
            cacheB.putAll(cacheA);
        }
    }

    private void updateCache(Map<String, String> cache, BlockKeyCacheModel blockKeyCacheModel) {
        //插入
        if (blockKeyCacheModel.getStatus() != 2) {
            cache.put(blockKeyCacheModel.getId(), blockKeyCacheModel.getWord());
        } else {
            cache.remove(blockKeyCacheModel.getId());
        }
    }
}