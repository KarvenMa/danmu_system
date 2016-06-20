package cn.partytime.service;

import cn.partytime.model.BlockKeyword;
import cn.partytime.repository.manager.BlockKeywordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by liuwei on 16/6/15.
 */

@Service
@Slf4j
public class BlockKeywordService {

    @Autowired
    private BlockKeywordRepository blockKeywordRepository;

    public void delete(String id) {
        blockKeywordRepository.delete(id);
    }

    public BlockKeyword findByWord(String word) {
        if (StringUtils.isEmpty(word)) {
            return null;
        }
        return blockKeywordRepository.findByWord(word);
    }

    public void save(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }

        BlockKeyword isExist = findByWord(word);
        if( null != isExist){
            return;
        }
        BlockKeyword blockKeyword = new BlockKeyword();
        blockKeyword.setWord(word.trim());
        blockKeywordRepository.insert(blockKeyword);
        //todo 通知消息中心更新敏感词
    }

    public List<BlockKeyword> findAll(){
        return blockKeywordRepository.findAll();
    }

    public Page<BlockKeyword> findAll(int page,int size){
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        PageRequest pageRequest = new PageRequest(page,size,sort);
        return blockKeywordRepository.findAll(pageRequest);
    }


}
