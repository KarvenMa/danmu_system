package cn.partytime.collector.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by user on 2016/6/14.
 */

@Configuration
@EnableRabbit
public class AMQPConfiguration {


    private int count = 50;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(rabbitTemplate.getConnectionFactory());
    }

    @PostConstruct
    public void init(){
        initDirectMq(MessageQueue.DANMU_QUEUE_FIRST.DANMU_QUEUE_FIRST_CXCHANGENAME,MessageQueue.DANMU_QUEUE_FIRST.DANMU_QUEUE_FIRST_QUEUE_NAME,MessageQueue.DANMU_QUEUE_FIRST.DANMU_QUEUE_FIRST_ROUTINGKEY_NAME);

    }

    public void initMq(String topicExchangeName, String queueName, String routingKey) {
        RabbitAdmin rabbitAdmin = rabbitAdmin();

        TopicExchange topicExchange = new TopicExchange(topicExchangeName);
        rabbitAdmin.declareExchange(topicExchange);

        Queue queue = new Queue(queueName);
        rabbitAdmin.declareQueue(queue);

        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(topicExchange).with(routingKey));

    }


    public void initDirectMq(String directExchangeName,String queueName,String routingKey){
        RabbitAdmin rabbitAdmin = rabbitAdmin();

        Queue queue = new Queue(queueName);
        rabbitAdmin.declareQueue(queue);

        DirectExchange directExchange = new DirectExchange(directExchangeName);
        rabbitAdmin.declareExchange(directExchange);

        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(directExchange).with(routingKey));
    }


    public void initFanoutMq(String fanoutExchangeName) {
        RabbitAdmin rabbitAdmin = rabbitAdmin();

        Queue queue = rabbitAdmin.declareQueue();

        FanoutExchange exchange = new FanoutExchange(fanoutExchangeName);
        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange));
    }


    /**
     * 监听消息队列
     * @param message
     */
    /*@RabbitListener(queues = MessageQueue.DANMU_QUEUE_FIRST.DANMU_QUEUE_FIRST_QUEUE_NAME)
    public void refreshIndex(Message message) {
        String data = new String(message.getBody());
           System.out.println("收到消息==============>"+data);

    }*/

}
