package cn.partytime.collector.service;

import cn.partytime.model.Danmu;
import cn.partytime.service.DanmuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by user on 16/6/22.
 */

@Service("danmuCollectorDanmuService")
public class DanmuCollectorDanmuServiceImpl implements DanmuCollectorDanmuService {

    @Autowired
    private DanmuService danmuService;


    /**
     *
     * @param msg 发送的消息
     * @param color 颜色
     * @param isBlockKey 是否是敏感词
     * @param type 类型
     * @param date 日期
     * @param danmuPoolId 弹幕池编号
     * @param userId 用户编号
     */
    @Override
    public void danmuSave(String msg, String color, boolean isBlockKey, int type, Date date, String danmuPoolId, String userId) {
        Danmu danmu = new Danmu();
        danmu.setColor(color);
        danmu.setMsg(msg);
        danmu.setIsBlocked(isBlockKey);
        danmu.setType(type);
        danmu.setDanmuPoolId(danmuPoolId);
        danmu.setUserId(userId);
        danmuService.save(danmu);
    }
}
