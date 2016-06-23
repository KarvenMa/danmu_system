package cn.partytime.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by liuwei on 16/6/23.
 */

@Configuration
@EnableRedisHttpSession
public class SessionConfig {


        @Bean
        public JedisConnectionFactory connectionFactory() {
            return new JedisConnectionFactory();
        }

}
