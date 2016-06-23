package cn.partytime.collector.netty;

import cn.partytime.collector.config.BlockKeywordCache;
import cn.partytime.collector.rabbitmq.MessageQueue;
import cn.partytime.collector.service.DanmuCollectorDanmuService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by user on 2016/6/15.
 */
@Component
@Qualifier("danmuServerHandler")
@ChannelHandler.Sharable
public class DanmuServerHandler extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BlockKeywordCache blockKeywordCache;

    @Resource(name = "danmuCollectorDanmuService")
    private DanmuCollectorDanmuService danmuCollectorDanmuService;


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.add(channel);
        System.out.println("[SERVER] - " + channel.id()+ " 加入\n");

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("[SERVER] - " + incoming.id()+ "离开\n");
        channels.remove(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {

        //TODO:s是一个json.此处需要和客户端协商。然后再处理
        //判断用户是否合法



        boolean isBlockKey = blockKeywordCache.matchBlockKey(s);
        if(isBlockKey){
            //内部存在非法词汇。将数据存入mongo
            //danmuCollectorDanmuService.danmuSave();
            //TODO:如果此处的消息含有敏感词，是否通知用户，待定。

        }else{
            rabbitTemplate.convertAndSend(MessageQueue.DANMU_QUEUE_FIRST.DANMU_QUEUE_FIRST_CXCHANGENAME, MessageQueue.DANMU_QUEUE_FIRST.DANMU_QUEUE_FIRST_ROUTINGKEY_NAME, s);

        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (7)
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
