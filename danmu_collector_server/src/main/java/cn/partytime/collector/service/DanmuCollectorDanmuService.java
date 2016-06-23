package cn.partytime.collector.service;

import java.util.Date;

/**
 * Created by user on 16/6/22.
 */
public interface DanmuCollectorDanmuService {


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
    void danmuSave(String msg,String color,boolean isBlockKey,int type,Date date,String danmuPoolId,String userId);
}
