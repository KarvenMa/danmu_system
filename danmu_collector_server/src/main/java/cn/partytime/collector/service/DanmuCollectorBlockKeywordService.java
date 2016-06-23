package cn.partytime.collector.service;

import cn.partytime.logic.blockKey.BlockKeyCacheModel;

import java.util.List;

/**
 * Created by user on 16/6/22.
 */
public interface DanmuCollectorBlockKeywordService {

    List<BlockKeyCacheModel> findAll();
}
