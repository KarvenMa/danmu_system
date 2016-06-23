package cn.partytime.collector.rabbitmq;

/**
 * Created by user on 2016/6/14.
 */
public interface MessageQueue {

    /**
     * 存放上传的所有弹幕
     */
    public static class DANMU_QUEUE_FIRST{
        public static final String DANMU_QUEUE_FIRST_CXCHANGENAME ="danmu.queue.exchangename.first";
        public static final String DANMU_QUEUE_FIRST_QUEUE_NAME ="danmu.queue.first";
        public static final String DANMU_QUEUE_FIRST_ROUTINGKEY_NAME ="danmu.queue.routingkey.first";
    }

}
